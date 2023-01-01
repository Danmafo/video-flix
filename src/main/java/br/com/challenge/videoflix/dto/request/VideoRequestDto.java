package br.com.challenge.videoflix.dto.request;

public record VideoRequestDto(
        Long id,
        String titulo,
        String descricao,
        String url
) {
}
