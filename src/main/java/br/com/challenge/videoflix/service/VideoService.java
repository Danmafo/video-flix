package br.com.challenge.videoflix.service;

import br.com.challenge.videoflix.dto.request.VideoAtualizacaoRequestDto;
import br.com.challenge.videoflix.dto.request.VideoCadastroRequestDto;
import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.entity.Video;
import br.com.challenge.videoflix.repository.VideoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository repository;

    public List<VideoResponseDto> listar() {
        List<Video> listaEntidade = repository.findAll();
        List<VideoResponseDto> listaDto = listaEntidade.stream().map(VideoResponseDto::converteEntidadeParaDto).toList();
        return listaDto;
    }

    public VideoResponseDto buscarPorId(Long id) {
        Video entidade = repository.getReferenceById(id);
        return VideoResponseDto.converteEntidadeParaDto(entidade);
    }

    public VideoResponseDto cadastrar(VideoCadastroRequestDto dto) {
        Video entidade = new Video();
        BeanUtils.copyProperties(dto, entidade);
        repository.save(entidade);
        return VideoResponseDto.converteEntidadeParaDto(entidade);
    }

    public VideoResponseDto atualizar(Long id, VideoAtualizacaoRequestDto dto) {
        Video entidade = repository.getReferenceById(id);
        return VideoResponseDto.converteEntidadeParaDto(
                repository.save(VideoAtualizacaoRequestDto.atualizar(entidade, dto))
        );
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
