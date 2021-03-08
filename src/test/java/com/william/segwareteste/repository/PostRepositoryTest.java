
package com.william.segwareteste.repository;

import com.william.segwareteste.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest
{

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testaSeEstaSalvandoNoBanco() {

        Post post = new Post();
        post.setConteudo("Lorem Ipsum Lorem Ipsum");
        post.setAutor("William");


        // SimpleDateFormat formatador = new SimpleDateFormat("dMMMy HH:mm");

        postRepository.save(post);
        Optional<Post> postPraSalvar = postRepository.findById(post.getId());

        assertThat(postPraSalvar.get().getId()).isNotNull();
        assertEquals("William", postPraSalvar.get().getAutor());
        assertEquals("Lorem Ipsum Lorem Ipsum", postPraSalvar.get().getConteudo());
        assertEquals("0", postPraSalvar.get().getUpvotes());
        //  assertEquals(formatador.format(data), modeloSalvo.get().getDataPostagem());
        //testa se a data está vindo formatada


    }

    @Test
    public void osUltimosDevemSerOsPrimeiros_e_TestaTamanhoDaLista() {
        Post post = new Post();
        post.setConteudo("Conteudo teste");
        post.setAutor("William");

        Post post1 = new Post();
        post1.setConteudo("Conteudo qualquer");
        post1.setAutor("Maria");

        Post post2 = new Post();
        post2.setConteudo("Conteudo qualquer");
        post2.setAutor("Maria");

        Post post3 = new Post();
        post3.setConteudo("Conteudo qualquer");
        post3.setAutor("Maria");

        postRepository.save(post);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        List<Post> listaPosts = postRepository.findByOrderByHorarioPostagemDesc();

        assertThat(listaPosts.size()).isEqualTo(4); //Verifica tamanho da lista

        Long ultimoId = post3.getId(); //pega o id do ultimo post salvo

        assertThat(listaPosts.get(0).getId()).isEqualTo(ultimoId);
        assertThat(listaPosts.get(0).getId()).isNotEqualTo(post.getId());

        //Aqui preciso que o ultimo post adicionado tenha o ID igual ao item de posiçao 0 da Lista.
        //não tenho certeza quanto a precisão da lista e ordem de sql mas está funcionando
    }

}

