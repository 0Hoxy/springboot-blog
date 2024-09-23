package com.hoxy.springbootdeveloper.service;

import com.hoxy.springbootdeveloper.dto.AddPostDTO;
import com.hoxy.springbootdeveloper.entity.Post;
import com.hoxy.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자를 추가한다.
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Post save(AddPostDTO addPostDTO) {
        return blogRepository.save(addPostDTO.toEntity());
    }

}
