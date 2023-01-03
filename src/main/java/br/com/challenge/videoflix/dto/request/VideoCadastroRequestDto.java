package br.com.challenge.videoflix.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VideoCadastroRequestDto(

        @NotBlank(message = "O título do vídeo não pode ser nulo ou vazio!")
        @Size(max = 50, message = "O título do vídeo não pode ultrapassar {max} caracteres")
        String titulo,

        @NotBlank(message = "A descrição do vídeo não pode ser nulo ou vazio!")
        @Size(max = 150, message = "A descrição do vídeo não pode ultrapassar {max} caracteres")
        String descricao,

        @NotBlank(message = "A URL do vídeo não pode ser nulo ou vazio!")
        @Size(max = 200, message = "A URL do vídeo não pode ultrapassar {max} caracteres")
        String url
) {
}
