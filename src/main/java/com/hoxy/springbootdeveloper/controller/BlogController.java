package com.hoxy.springbootdeveloper.controller;

import com.hoxy.springbootdeveloper.dto.AddPostDTO;
import com.hoxy.springbootdeveloper.entity.Post;
import com.hoxy.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController //springWeb 의존성이 주입되어 있어야 RestController 어노테이션을 생성할 수 있다.
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/api/post")
    public ResponseEntity<Post> addPost(@RequestBody AddPostDTO addPostDTO) { //@ResponseBody로 요청 본문 값 매핑
        Post savePost = blogService.save(addPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED) //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송, 201 CREATED
                .body(savePost); //객체의 내용들도 함께 전달이 되어 JSON으로 구성이 된다.
    }
}
