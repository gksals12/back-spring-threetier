package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;

public interface MemberService {
    //    이름: 서비스의 직관적인 이름

    //  이메일 중복확인
    public boolean existMemberEmail(String memberEmail);

    //  회원 가입
    public void register(MemberVO memberVO);

    /*로그인*/
    public MemberResponseDTO login(MemberVO memberVO);

    public MemberResponseDTO modify(MemberVO memberVO);

    public boolean withdraw(Long id);
}
