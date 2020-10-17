package com.przemyslawwolosz.module.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BlogPostController {

    @RequestMapping(path = "/blog/posts", method = RequestMethod.GET)
    public String getPostList(Model model) {
        return "blog/posts";
    }

    @RequestMapping(params = "/blog/posts", method = RequestMethod.POST)
    public String createPost() {
        return "redirect:/blog/posts/" + "0-1-2-3";
     }

    @RequestMapping(path = "/blog/posts/{uuid}", method = RequestMethod.GET)
    public String getPost(@PathVariable("uuid") String uuid, Model model) {
        model.addAttribute("post", uuid);
        return "blog/post";
    }
}
