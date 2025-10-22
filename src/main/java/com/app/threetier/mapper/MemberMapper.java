package com.app.threetier.mapper;

import com.app.threetier.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    /*이메일 중복확인*/
    public boolean existMemberEmail(String memberEmail);

    /*회원 가입*/
    public void insert(MemberVO memberVO);

    /*회원 조회*/
    public Optional<MemberVO> select(Long id);

    /*이메일로 id 조회*/
    public Long selectIdByMemberEmail(String memberEmail);

    public void update(MemberVO memberVO);

    public void delete(Long id);
}
