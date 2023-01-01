package br.com.challenge.videoflix.service;

import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.entity.Video;
import br.com.challenge.videoflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository repository;

    public List<VideoResponseDto> listar() {
        List<Video> listaEntidade = repository.findAll();
        List<VideoResponseDto> listaDto = listaEntidade.stream().map(VideoResponseDto::converteEntidadeParaDto).toList();
        return listaDto;
    }

}
