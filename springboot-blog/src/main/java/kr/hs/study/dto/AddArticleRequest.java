package kr.hs.study.dto;

import kr.hs.study.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor      // 기본 생성자 추가
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    // Builder 패턴을 사용해 DTO를 Entity롤 만들어주는 메서드
    public Article toEntity() {
        // 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
