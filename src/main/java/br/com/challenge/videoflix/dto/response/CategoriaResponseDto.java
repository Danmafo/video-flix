package br.com.challenge.videoflix.dto.response;

import br.com.challenge.videoflix.entity.Categoria;
import br.com.challenge.videoflix.entity.Video;

public record CategoriaResponseDto(

        Long id,
        String titulo,
        String cor
) {

    public static CategoriaResponseDto converteEntidadeParaDto(Categoria categoria) {
        return new CategoriaResponseDto(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }

}
