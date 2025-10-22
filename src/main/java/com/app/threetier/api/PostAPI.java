package com.app.threetier.api;

import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostAPI {

    final private PostService postService;

    @PostMapping("write")
    public void write(PostVO postVO){
        postService.write(postVO);
    }

    @GetMapping("list")
    public void showListOrderByDesc(){
        postService.showPostList();
    }

    @PostMapping("read")
    public void showPost(Long postId){
        postService.showPostByPostId(postId);
    }

    @PutMapping("update")
    public void update(PostVO postVO){
        postService.update(postVO);
    }
}
