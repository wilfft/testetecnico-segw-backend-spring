package com.william.segwareteste.controller;

import com.william.segwareteste.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


    @GetMapping("/api/postagens")
    public Iterable<Post> receberPosts() {

        return null;
    }

    @PostMapping("/api/postagens")
    public ResponseEntity salvarPost(@RequestBody Post post) {

        return null;
    }

}
