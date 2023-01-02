package br.com.challenge.videoflix.dto.request;

public record VideoRequestDto(
        String titulo,
        String descricao,
        String url
) {
}
