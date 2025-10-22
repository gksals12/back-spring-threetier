package com.app.threetier.dao;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostDaoTests {

    @Autowired
    private PostDAO postDAO;

    @Test
    public void saveTest() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("TitleTestDao123");
        postVO.setPostContent("ContentTestDao123");
        postVO.setMemberId(2L);
        postDAO.save(postVO);
    }

    @Test
    public void showPostListTest() {
        postDAO.showPostList().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void showPostByPostIdTest() {
        postDAO.showPost(2L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        PostVO  postVO = new PostVO();
        postVO.setId(2L);
        postVO.setPostTitle("UpdateTitleTestDao123");
        postVO.setPostContent("UpdateContentTestDao123");
        postDAO.update(postVO);
    }
}
