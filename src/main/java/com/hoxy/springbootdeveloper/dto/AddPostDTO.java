package com.hoxy.springbootdeveloper.dto;

import com.hoxy.springbootdeveloper.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //기본 생성자 추가
@AllArgsConstructor //모든 필드를 파라미터로 받는 생성자 추가
@Getter
@Setter
public class AddPostDTO {
    private String title;
    private String content;

    public Post toEntity() { //블로그 글을 추가 할때 사용한 DTO를 저장하기 위해 엔티티로 변환하는 용도, 의문: ModelMapper 사용하면 안되려나?
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
