package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.exception.PostException;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    final private PostDAO postDAO;

    @Override
    public Long write(PostVO postVO) {
        Long postId = postDAO.save(postVO);
        return postId;
    }

    @Override
    public List<PostDTO> showPostList() {
        return postDAO.showPostList();
    }

    @Override
    public Optional<PostDTO> showPostByPostId(Long postId) {
        postDAO.increasePostReadCount(postId);
        return postDAO.showPost(postId);
    }

    @Override
    public void update(PostVO postVO) {
        postDAO.update(postVO);
    }

    @Override
    public void deletePostByPostId(Long postId) {
        postDAO.deletePostByPostId(postId);
    }

    @Override
    public void deletePostByMemberId(Long memberId) {
        postDAO.deletePostByMemberId(memberId);
    }
}
