package com.ioutstanding.postblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "api/v1/categories")
    public List<String> categories() {
        List<Article> allArticles = articleRepository.findAll();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < allArticles.size(); ++i) {
            result.add(allArticles.get(i).getCategory());
        }

        return result;

    }
}
