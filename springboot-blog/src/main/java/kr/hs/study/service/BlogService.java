package kr.hs.study.service;

import kr.hs.study.domain.Article;
import kr.hs.study.dto.AddArticleRequest;
import kr.hs.study.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor        // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service        // 빈으로 서블릿 컨테이너에 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
