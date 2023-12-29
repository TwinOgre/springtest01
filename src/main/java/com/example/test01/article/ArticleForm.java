package com.example.test01.article;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목을 비울 수 없습니다.")
    @Max(200)
    private String subject;

    @NotEmpty
    private String content;
}
