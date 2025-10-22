package com.app.threetier.dao;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberDaoTests {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void test(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring456@gmail.com");
        memberVO.setMemberName("김영희");
        memberVO.setMemberPassword("1234");
        memberDAO.save(memberVO);
    }

    @Test
    public void findMemberTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("spring123@gmail.com");
        memberVO.setMemberName("김길동");
        memberVO.setMemberPassword("1234");
//        Optional<MemberVO> foundMember = memberDAO.findMemberById( memberVO);
//        foundMember.map(MemberVO::toString).ifPresent(log::info);
    }
}
