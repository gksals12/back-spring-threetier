package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void writeTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("TestTitle123");
        postVO.setPostContent("TestContent123");
        postVO.setMemberId(1L);
        postMapper.insert(postVO);
    }

    @Test
    public void showPostListTest(){
        postMapper.selectAllPostOrderByDesc().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void showPostByPostIdTest(){
        postMapper.selectPostByPostId(6L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        PostVO postVO = new PostVO();
        postVO.setId(1L);
        postVO.setPostTitle("UpdateTitleTestMapper123");
        postVO.setPostContent("UpdateContentTestMapper123");
        postMapper.update(postVO);
    }
}
