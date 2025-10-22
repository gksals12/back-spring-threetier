package com.app.threetier.repository;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    final private MemberMapper memberMapper;

    //  이메일 중복확인
    public boolean existMemberEmail(String memberEmail) {
        return memberMapper.existMemberEmail(memberEmail);
    }

    //  회원 가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    /*아이디로 회원 조회*/
    public Optional<MemberVO> findMemberById(Long id) {
        return memberMapper.select(id);
    }

    /*이메일로 아이디 조화*/
    public Long findMemberIdByMemberEmail(String memberEmail) {
        return memberMapper.selectIdByMemberEmail(memberEmail);
    }

    public void updateMember(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

    public void deleteMember(Long id) {
        memberMapper.delete(id);
    }

}
