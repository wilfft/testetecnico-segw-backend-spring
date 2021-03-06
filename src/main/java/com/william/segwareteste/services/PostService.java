package com.william.segwareteste.services;

import com.william.segwareteste.entity.Post;
import com.william.segwareteste.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> receberPosts() {
        return this.postRepository.findByOrderByHorarioPostagemDesc();
    }

    @Transactional
    public Post salvarPostagem(Post post) {
        post.setHorarioPostagem(Instant.now());
        post.setUpvotes(0);
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public Post darUpVote(Long id) {
     //   Optional<Post> postVotado = postRepository.findById(id);
        var postEscolhido = findById(id);
            if (postEscolhido.isPresent()) {
                postEscolhido.get().setUpvotes(postEscolhido.get().getUpvotes() + 1);
               Post postVotado=  postRepository.save(postEscolhido.get());
                return postVotado;
                  }
        return null;
    }

}
