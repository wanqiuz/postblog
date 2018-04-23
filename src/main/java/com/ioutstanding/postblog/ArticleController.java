package com.ioutstanding.postblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(value = "api/v1/articles")
    public List<Article> articleFindAll() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "api/v1/articles/{id}")
    public Article articleFindById(@PathVariable(value = "id") Integer id) {
        return articleRepository.findById(id).get();
    }
}
