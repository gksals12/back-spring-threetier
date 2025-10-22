package com.app.threetier.repository;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    final private PostMapper postMapper;

    //  글 등록
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

    //  글 전체 조회
    public List<PostDTO> showPostList() {
        return postMapper.selectAllPostOrderByDesc();
    }

    //  글 상세조회
    public Optional<PostDTO> showPost(Long postId) {
        return postMapper.selectPostByPostId(postId);
    }

    //  글 수정
    public void update(PostVO postVO) {
        postMapper.update(postVO);
    }

    //  조회수 증가
    public void increasePostReadCount(Long postId) {
        postMapper.updatePostReadCount(postId);
    }

    //  글 삭제
    public void deletePostByPostId(Long postId) {
        postMapper.deletePostByPostId(postId);
    }

    public void deletePostByMemberId(Long memberId) {
        postMapper.deletePostByMemberId(memberId);
    }
}
