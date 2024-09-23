package com.hoxy.springbootdeveloper.repository;

import com.hoxy.springbootdeveloper.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post, Long> { //JpaRepository 클래스를 상속받을 때 엔티티 Post와 엔티티 기본키 타입을 Long을 인수로 넣었다.

}
