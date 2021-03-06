package com.william.segwareteste.dto;

import org.ocpsoft.prettytime.PrettyTime;

import java.time.Instant;
import java.util.Date;

public class PostDTO {

    private Long id;
    private String autor;
    private String conteudo;
    private Instant horarioPostagem;
    private Integer upvotes;

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

    public PrettyTime getHorarioPostagem() {
        PrettyTime dataFormatada = new PrettyTime();

        return dataFormatada;
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
}
