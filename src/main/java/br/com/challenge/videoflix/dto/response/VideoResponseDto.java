package br.com.challenge.videoflix.dto.response;

import br.com.challenge.videoflix.entity.Video;

public record VideoResponseDto(
        Long id,
        String titulo,
        String descricao,
        String url
) {

    public static VideoResponseDto converteEntidadeParaDto(Video video) {
        return new VideoResponseDto(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }

}
