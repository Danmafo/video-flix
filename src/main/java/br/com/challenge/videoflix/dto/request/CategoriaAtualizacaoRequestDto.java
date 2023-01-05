package br.com.challenge.videoflix.dto.request;

import br.com.challenge.videoflix.entity.Categoria;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CategoriaAtualizacaoRequestDto(

    @Size(max = 25, message = "O título da cor não pode ultrapassar {max} caracteres")
    String titulo,

    @Size(max = 7, message = "O título da cor não pode ultrapassar {max} caracteres")
    @Pattern(regexp = "^#([A-F0-9]{6}|[A-F0-9]{3})$", message = "A cor precisa estar no formato hexadecimal!")
    String cor

) {

    public static Categoria atualizar(Categoria atualizando, CategoriaAtualizacaoRequestDto dto) {
        if (dto.titulo != null) {
            atualizando.setTitulo(dto.titulo);
        }
        if (dto.cor != null) {
            atualizando.setCor(dto.cor);
        }
        return atualizando;
    }

}
