package com.hoxy.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터가 없는 디폴트 생성자 자동생성
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 필드에 대해 not null 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder //빌더 패턴으로 객체 생성, 생성자나 Setter 메서드 대신, 필요한 메서드만 선택적으로 설정하고 객체를 생성할 수 있다. 빌더의 사용 이유는 맞춤형 생성자보다 더 많은 유연성과 편리함을 제공하기 때문이다.
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

