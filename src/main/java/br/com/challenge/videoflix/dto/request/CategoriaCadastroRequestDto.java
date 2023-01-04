package br.com.challenge.videoflix.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CategoriaCadastroRequestDto(

        @NotBlank(message = "O título da cor não pode ser nulo ou vazio!")
        @Size(max = 25, message = "O título da cor não pode ultrapassar {max} caracteres")
        String titulo,

        @NotBlank(message = "O cor não pode ser nulo ou vazio!")
        @Size(max = 7, message = "O título da cor não pode ultrapassar {max} caracteres")
        @Pattern(regexp = "^#([A-F0-9]{6}|[A-F0-9]{3})$", message = "A cor precisa estar no formato hexadecimal!")
        String cor
) {
}
