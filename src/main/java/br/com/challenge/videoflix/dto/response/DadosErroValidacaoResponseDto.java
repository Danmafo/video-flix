package br.com.challenge.videoflix.dto.response;

import org.springframework.validation.FieldError;

public record DadosErroValidacaoResponseDto(
        String campo,
        String mensagem
) {

    public DadosErroValidacaoResponseDto(FieldError erro) {
        this(erro.getField(), erro.getDefaultMessage());
    }

}
