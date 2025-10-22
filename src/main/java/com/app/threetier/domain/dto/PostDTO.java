package com.app.threetier.domain.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Setter
@ToString
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
    private String memberName;
    private String memberEmail;
}
