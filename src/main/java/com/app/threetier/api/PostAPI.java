package com.app.threetier.api;

import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.dto.PostResponseDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostAPI {

    final private PostService postService;

    @PostMapping("write")
    public ResponseEntity<ApiResponseDTO<Object>> write(PostVO postVO){
        Long postId = postService.write(postVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("글이 등록되었습니다", postId));
    }

    @GetMapping("list")
    public ResponseEntity<ApiResponseDTO<Object>> showListOrderByDesc(){
        List<PostDTO> postList = postService.showPostList();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("리스트를 정상적으로 가져왔습니다", postList));
    }

    @PostMapping("read")
    public ResponseEntity<ApiResponseDTO<Object>> showPost(Long postId){
       Optional<PostDTO> post = postService.showPostByPostId(postId);
       return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("글을 성공적으로 가져왔습니다", post));
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponseDTO<Object>> update(PostVO postVO){
        postService.update(postVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("수정이 완료되었습니다"));
    }

    @DeleteMapping("delete")
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long postId){
        postService.deletePostByPostId(postId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of(("게시글 삭제 완료")));
    }
}
