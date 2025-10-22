package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    //  글 등록
    public void insert(PostVO postVO);

    //  글 전체 조회
    public List<PostDTO> selectAllPostOrderByDesc();

    //  글 상세 조회
    public Optional<PostDTO> selectPostByPostId(Long postId);

    //  글 수정
    public void update(PostVO postVO);

    //  조회수 증가
    public void updatePostReadCount(Long postId);

    //  글 삭제
    public void deletePostByPostId(Long postId);

    public void deletePostByMemberId(Long memberId);
}
