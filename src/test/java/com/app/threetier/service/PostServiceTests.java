package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void writeTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("TitleTestService123");
        postVO.setPostContent("ContentTestService123");
        postVO.setMemberId(3L);
        postService.write(postVO);
    }

    @Test
    public void showPostListTest(){
        postService.showPostList().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void showPostByIdTest(){
        postService.showPostByPostId(6L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("UpdateTitleTestMapper123");
        postVO.setPostContent("UpdateContentTestMapper123");
        postVO.setMemberId(3L);
        postService.update(postVO);
    }

    @Test
    public void deletePostByMemberIdTest(){
        postService.deletePostByMemberId(3L);
    }
}
