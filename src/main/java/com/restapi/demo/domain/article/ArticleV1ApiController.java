package com.restapi.demo.domain.article;

import com.restapi.demo.global.rsdata.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleV1ApiController {
    private final ArticleService articleService;

    @AllArgsConstructor
    @Getter
    public static class ArticleResponce {
        private final List<Article> articles;
    }

    @AllArgsConstructor
    @Getter
    public static class ArticleResponce2 {
        private final Article article;
    }

    @GetMapping("")
    public RsData<ArticleResponce> articles() {

        List<Article> articles = new ArrayList<>(){{
            add(new Article(1L, "제목1", "내용1", LocalDateTime.now()));
            add(new Article(2L, "제목2", "내용2", LocalDateTime.now()));
            add(new Article(3L, "제목3", "내용3", LocalDateTime.now()));
        }};

        return RsData.of(
                "s-1",
                "성공",
                new ArticleResponce(articles)
        );
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponce2> article(@PathVariable("id") Long id) {

        List<Article> articles = new ArrayList<>(){{
            add(new Article(1L, "제목1", "내용1", LocalDateTime.now()));
            add(new Article(2L, "제목2", "내용2", LocalDateTime.now()));
            add(new Article(3L, "제목3", "내용3", LocalDateTime.now()));
        }};

        Article article = articles.get(id.intValue() - 1);

        return RsData.of(
                "s-2",
                "성공",
                new ArticleResponce2(article)
        );
    }
}
