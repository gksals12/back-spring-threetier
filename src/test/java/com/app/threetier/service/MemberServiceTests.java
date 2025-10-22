package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberResponseDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void test(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test789@gmail.com");
        memberVO.setMemberName("이순신");
        memberVO.setMemberPassword("1234");
        memberService.register(memberVO);
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring12345@gmail.com");
        memberVO.setMemberName("김길동");
        memberVO.setMemberPassword("1234");
        MemberResponseDTO foundMember = memberService.login(memberVO);
        log.info("foundMember:{}",foundMember);
    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(25L);
        memberVO.setMemberEmail("spring12345@gmail.com");
        memberVO.setMemberName("수철김");
        memberVO.setMemberPassword("1234");
        memberService.modify(memberVO);
    }

    @Test
    public void deleteTest(){
        if(memberService.withdraw(25L)){
            log.info("삭제 완료");
        }else{
            log.info("삭제 실패");
        }
    }
}
