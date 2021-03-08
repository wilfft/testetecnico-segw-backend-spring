package com.william.segwareteste.services;

import com.william.segwareteste.entity.Post;
import com.william.segwareteste.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {


    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void deveSalvarPosteVerificarConteudo() {
        Post post = new Post();
        post.setAutor("nome recebido");
        post.setConteudo("conteudo recebido");
        Post novo = postService.salvarPostagem(post);

        assertThat(novo).isNotNull();
        assertThat(novo.getId()).isNotNull();
    }


    @Test
    public void deveConferirSeUpVoteFoiComputado() {
        Post post = new Post();
        post.setAutor("nome recebido");
        post.setConteudo("conteudo recebido");
//up vote inicia em 0, vou dar um voto e conferir o resultado depois conferir se somou de fato
        Post postSalvo = postService.salvarPostagem(post);
        postService.darUpVote(postSalvo.getId());
        Optional<Post> postLocalizado = postRepository.findById(postSalvo.getId());
        assertThat(postLocalizado.get().getUpvotes()).isEqualTo(1);
        assertThat(postLocalizado.get().getUpvotes()).isEqualTo(post.getUpvotes() + 1);
    }


    @Test(expected = TransactionSystemException.class)
    public void deveFalharAoCadastrar_qandoConteudoForNulo() {
        Post post = new Post();
        post.setConteudo(null);
        post = postService.salvarPostagem(post);
    }

    @Test(expected = TransactionSystemException.class)
    public void deveFalharAoCadastrar_quandoNomeForNulo() {
        Post post = new Post();
        post.setAutor(null);
        post = postService.salvarPostagem(post);
    }



}
