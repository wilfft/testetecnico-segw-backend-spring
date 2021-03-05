package com.william.segwareteste.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String autor;
    private String conteudo;
    private Instant horarioPostagem;
    private Integer upvotes;

    public long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Instant getHorarioPostagem() {
        return horarioPostagem;
    }

    public void setHorarioPostagem(Instant horarioPostagem) {
        this.horarioPostagem = horarioPostagem;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "autor='" + autor + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", horarioPostagem=" + horarioPostagem +
                ", upvotes=" + upvotes +
                '}';
    }
}
