package kr.hs.study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter     // lombok : 코드 반복 입력을 줄여서 가독성 향상
@NoArgsConstructor(access = AccessLevel.PROTECTED)      // protected인 기본 생성자 생성
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder        // builder 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
