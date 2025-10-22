package com.app.threetier.domain.vo;

import lombok.*;

@NoArgsConstructor
@Getter @EqualsAndHashCode(of = "id")
@Setter @ToString
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
