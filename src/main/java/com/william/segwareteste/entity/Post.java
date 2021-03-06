package com.william.segwareteste.entity;

import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 70, message = "Nome precisa ter no minimo 2 caracteres")
    private String autor;

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 1000, message = "Conteudo precisa ter de 2 a 1000 caracteres")
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

    public String getHorarioPostagem() {
        PrettyTime dataFormatada = new PrettyTime();

        return dataFormatada.format(horarioPostagem.minusSeconds(1));
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
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", horarioPostagem=" + getHorarioPostagem() +
                ", upvotes=" + upvotes +
                '}';
    }
}
