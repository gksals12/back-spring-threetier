package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    //  글등록
    public Long write(PostVO postVO);

    //  글 전체 조회
    public List<PostDTO> showPostList();

    //  글 상세 조회
    public Optional<PostDTO> showPostByPostId(Long postId);

    //  글 수정
    public void update(PostVO postVO);

    //  글 삭제
    public void deletePostByPostId(Long postId);

    public void deletePostByMemberId(Long memberId);
}
