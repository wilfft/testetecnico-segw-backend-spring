package com.william.segwareteste.controller;

import com.william.segwareteste.entity.Post;
import com.william.segwareteste.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity salvaPostagem(@RequestBody   Post post) {
      try {
        postService.salvarPostagem(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post.toString() );
    } catch (Exception exception) {
        System.out.println(exception);
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }
}
    @PutMapping("/api/postagens/upvote{id}")
    public ResponseEntity votarPost(@RequestParam Long id) {
try{
    if (postService.darUpVote(id)!=null){
        return ResponseEntity.status(HttpStatus.OK).body("Post votado");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post nao encontrado");
    }

} catch (Exception exception) {
    System.out.println(exception);
    return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
}
    }
}
