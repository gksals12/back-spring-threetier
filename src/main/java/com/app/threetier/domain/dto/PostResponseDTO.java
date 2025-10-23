package com.app.threetier.domain.dto;

import com.app.threetier.domain.vo.PostVO;
import lombok.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Setter
@ToString
public class PostResponseDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
    private String memberName;
    private String memberEmail;

    PostResponseDTO(PostDTO postDTO) {
        this.id = postDTO.getId();
        this.postTitle = postDTO.getPostTitle();
        this.postContent = postDTO.getPostContent();
        this.postReadCount = postDTO.getPostReadCount();
        this.memberId = postDTO.getMemberId();
        this.memberName = postDTO.getMemberName();
        this.memberEmail = postDTO.getMemberEmail();
    }
}
