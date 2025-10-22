package com.app.threetier.domain.vo;

import lombok.*;

@NoArgsConstructor
@Getter @EqualsAndHashCode(of = "id")
@Setter @ToString
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
}
