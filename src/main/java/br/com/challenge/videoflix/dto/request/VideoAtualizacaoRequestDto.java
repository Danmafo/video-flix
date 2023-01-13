package br.com.challenge.videoflix.dto.request;

import br.com.challenge.videoflix.entity.Video;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public record VideoAtualizacaoRequestDto(

        @Size(max = 50, message = "O título do vídeo não pode ultrapassar {max} caracteres")
        String titulo,

        @Max(value = 4, message = "O id da categora não pode ser maior que {value}")
        Long idCategoria,

        @Size(max = 150, message = "A descrição do vídeo não pode ultrapassar {max} caracteres")
        String descricao,

        @Size(max = 200, message = "A URL do vídeo não pode ultrapassar {max} caracteres")
        String url
) {

    public static Video atualizar(Video atualizando, VideoAtualizacaoRequestDto dto) {
        if (dto.titulo != null) {
            atualizando.setTitulo(dto.titulo);
        }
        if (dto.descricao != null) {
            atualizando.setDescricao(dto.descricao);
        }
        if (dto.url != null) {
            atualizando.setUrl(dto.url);
        }
        return atualizando;
    }

}
