package com.example.test01.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.list();
        model.addAttribute("articleList",articleList);
        return "article_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(){

        return "article_detail";
    }
    @GetMapping("/create")
    public String create(){

        return "article_form";
    }
    @PostMapping("/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult){

        this.articleService.create(articleForm.getSubject(),articleForm.getContent());

        return "redirect:/article/list";
    }
}
