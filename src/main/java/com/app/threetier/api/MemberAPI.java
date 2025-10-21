package com.app.threetier.api;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberAPI {

    final private MemberService memberService;

    @PostMapping("register")
    public void register(MemberVO memberVO) {
        memberService.register(memberVO);
    }
}
