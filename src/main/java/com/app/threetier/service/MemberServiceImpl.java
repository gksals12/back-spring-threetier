package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.exception.MemberException;
import com.app.threetier.exception.MemberExistEmailException;
import com.app.threetier.exception.MemberNotFoundException;
import com.app.threetier.exception.MemberPasswordException;
import com.app.threetier.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    final private MemberDAO memberDAO;
    final private PasswordEncoder passwordEncoder;

    @Override
    public boolean existMemberEmail(String memberEmail) {
        if(!memberDAO.existMemberEmail(memberEmail)){
            throw new MemberExistEmailException("이메일이 중복");
        }

        return memberDAO.existMemberEmail(memberEmail);
    }

    @Override
    public void register(MemberVO memberVO) {
        //  암호화
        String encodedPassword = passwordEncoder.encode(memberVO.getMemberPassword());
        memberVO.setMemberPassword(encodedPassword);
        memberDAO.save(memberVO);
    }

    @Override
    public MemberResponseDTO login(MemberVO memberVO) {
        if(!memberDAO.existMemberEmail(memberVO.getMemberEmail())) {
            throw new MemberExistEmailException("이메일이 존재하지 않습니다.");
        }

        Long id = memberDAO.findMemberIdByMemberEmail(memberVO.getMemberEmail());

        MemberVO foundMember = memberDAO.findMemberById(id).orElseThrow(() -> new MemberNotFoundException("유저를 찾을 수 없습니다"));

        if(!passwordEncoder.matches(memberVO.getMemberPassword(), foundMember.getMemberPassword())){
            throw new MemberPasswordException("비밀번호가 일치하지 않습니다");
        }

        MemberResponseDTO memberResponse = new MemberResponseDTO(foundMember);
        return memberResponse;
    }

    @Override
    public MemberResponseDTO modify(MemberVO memberVO) {
        memberVO.setMemberPassword(passwordEncoder.encode(memberVO.getMemberPassword()));
        memberDAO.updateMember(memberVO);

        MemberVO foundMember =  memberDAO.findMemberById(memberVO.getId()).orElseThrow(() -> new MemberNotFoundException("유저를 찾을 수 없습니다"));

        return new MemberResponseDTO(foundMember);
    }

    @Override
    public boolean withdraw(Long id) {
        /*모든 서비스들의 해당 유저 정보를 삭제 후 멤버 테이블에서 멤버를 삭제(소프트 삭제)*/
        boolean isWithdraw = false;
        try{
            memberDAO.deleteMember(id);
            return true;
        } catch (Exception a){
            return false;
        }
    }
}
