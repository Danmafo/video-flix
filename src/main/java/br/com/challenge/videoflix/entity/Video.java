package br.com.challenge.videoflix.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_videos")
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "url", length = 200)
    private String url;

    public Video() {
    }

    public Video(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

}
