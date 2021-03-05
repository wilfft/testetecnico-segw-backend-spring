package com.william.segwareteste.services;

import com.william.segwareteste.entity.Post;
import com.william.segwareteste.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> receberPosts() {
        return this.postRepository.findByOrderByHorarioPostagemDescDesc();
    }

    @Transactional
    public Post salvarPostagem(Post post) {
        post.setHorarioPostagem(Instant.now());
        post.setUpvotes(0);
        return postRepository.save(post)
    }

}
