package com.ioutstanding.postblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping(value = "/api/v1/tags")
    List<String> tagTypes() {
        List<Tag> allTags = tagRepository.findAll();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < allTags.size(); ++i) {
            if (!result.contains(allTags.get(i).getTag()))
                result.add(allTags.get(i).getTag());
        }

        return result;
    }

}
