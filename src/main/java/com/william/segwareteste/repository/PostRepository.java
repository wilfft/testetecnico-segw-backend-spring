package com.william.segwareteste.repository;

import com.william.segwareteste.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long  > {

    //Lista ordenado por horario da postagem em ordem decrescente
    List<Post> findByOrderByHorarioPostagemDescDesc();

}
