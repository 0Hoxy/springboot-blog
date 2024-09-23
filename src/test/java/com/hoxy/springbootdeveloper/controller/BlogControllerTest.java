package com.hoxy.springbootdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoxy.springbootdeveloper.dto.AddPostDTO;
import com.hoxy.springbootdeveloper.entity.Post;
import com.hoxy.springbootdeveloper.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest //테스트용 어플리케이션 컨텍스트
@AutoConfigureMockMvc //MockMVC 생성 및 자동 구성
class BlogControllerTest {

    @Autowired
    protected MockMvc mockMvc; //구글링 후 설명 붙히기
    @Autowired
    protected ObjectMapper objectMapper; //직렬화, 역직렬화를 위한 클래스, 자바 객체를 JSON으로, 또는 반대로 사요하기 위해서 사용
    @Autowired
    protected WebApplicationContext context; //구글링 후 설명 붙히기

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach //테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        blogRepository.deleteAll();
    }

    @DisplayName("addPost: 블로그에 글 추가에 성공하기") //성공
    @Test
    public void addPost() throws Exception {
        //given, given에 대해서 설명 달기
        final String url = "/api/post";
        final String title = "title";
        final String content = "content";
        final AddPostDTO userRequest = new AddPostDTO(title, content);

        //객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        //when, 설명달기!
        //설정한 내용을 바탕으로 요청을 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then, 설명 책에 있다. 설명 달자
        result.andExpect(status().isCreated());

        List<Post> posts = blogRepository.findAll();

        assertThat(posts.size()).isEqualTo(1); //리스트 크기 1인지 체크
        assertThat(posts.get(0).getTitle()).isEqualTo(title); //0번 인덱스의 title이 title과 같은지 체크
        assertThat(posts.get(0).getContent()).isEqualTo(content); // 내용 체크도 동일함
    }
}