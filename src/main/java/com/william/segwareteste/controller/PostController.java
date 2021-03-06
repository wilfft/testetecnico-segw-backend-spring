package com.william.segwareteste.controller;

import com.william.segwareteste.entity.Post;
import com.william.segwareteste.expection.ErroException;
import com.william.segwareteste.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/postagens")
    public Iterable<Post> receberPosts() {

        return postService.receberPosts();
    }

    @CrossOrigin
    @PostMapping("/api/postagens")
    public ResponseEntity salvaPostagem(@RequestBody @Valid Post post) {
        try {
            postService.salvarPostagem(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(post.toString());
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/postagens/upvote{id}")
    public ResponseEntity votarPost(@RequestParam Long id) {
        if (id == null) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
        try {
            Post postVotado = postService.darUpVote(id);
            if (postVotado!=null) {
                return ResponseEntity.status(HttpStatus.OK).body(postVotado + "\n Post votado");
            }
        } catch (ErroException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);


    }
}

