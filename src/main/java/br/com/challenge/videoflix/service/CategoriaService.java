package br.com.challenge.videoflix.service;

import br.com.challenge.videoflix.dto.request.CategoriaAtualizacaoRequestDto;
import br.com.challenge.videoflix.dto.request.CategoriaCadastroRequestDto;
import br.com.challenge.videoflix.dto.response.CategoriaResponseDto;
import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.entity.Categoria;
import br.com.challenge.videoflix.entity.Video;
import br.com.challenge.videoflix.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<CategoriaResponseDto> listar() {
        List<Categoria> listaEntidade = repository.findAll();
        List<CategoriaResponseDto> listaDto = listaEntidade.stream().map(CategoriaResponseDto::converteEntidadeParaDto).toList();
        return listaDto;
    }

    public CategoriaResponseDto buscarPorId(Long id) {
        Categoria entidade = repository.getReferenceById(id);
        return CategoriaResponseDto.converteEntidadeParaDto(entidade);
    }

    public CategoriaResponseDto cadastrar(CategoriaCadastroRequestDto dto) {
        Categoria entidade = new Categoria();
        BeanUtils.copyProperties(dto, entidade);
        repository.save(entidade);
        return CategoriaResponseDto.converteEntidadeParaDto(entidade);
    }

    public CategoriaResponseDto atualizar(Long id, CategoriaAtualizacaoRequestDto dto) {
        Categoria entidade = repository.getReferenceById(id);
        return CategoriaResponseDto.converteEntidadeParaDto(
                repository.save(CategoriaAtualizacaoRequestDto.atualizar(entidade, dto))
        );
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

}
