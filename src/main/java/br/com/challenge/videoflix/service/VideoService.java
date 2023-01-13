package br.com.challenge.videoflix.service;

import br.com.challenge.videoflix.dto.request.VideoAtualizacaoRequestDto;
import br.com.challenge.videoflix.dto.request.VideoCadastroRequestDto;
import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.entity.Video;
import br.com.challenge.videoflix.repository.VideoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    CategoriaService categoriaService;

    public List<VideoResponseDto> listar() {
        List<Video> listaEntidade = videoRepository.findAll();
        List<VideoResponseDto> listaDto = listaEntidade.stream().map(VideoResponseDto::converteEntidadeParaDto)
                .toList();
        return listaDto;
    }

    public VideoResponseDto buscarPorId(Long id) {
        Video entidade = videoRepository.getReferenceById(id);
        return VideoResponseDto.converteEntidadeParaDto(entidade);
    }

    public List<VideoResponseDto> buscarPorIdCategoria(Long id) {
        List<Video> listaEntidade = videoRepository.findByCategoria_Id(id);
        List<VideoResponseDto> listaDto = listaEntidade.stream().map(VideoResponseDto::converteEntidadeParaDto)
                .toList();
        return listaDto;
    }

    public List<VideoResponseDto> buscarPorTituloPesquisa(String pesquisa) {
        List<Video> listaEntidade = videoRepository.findByTituloContainingIgnoreCase(pesquisa);
        List<VideoResponseDto> listaDto = listaEntidade.stream().map(VideoResponseDto::converteEntidadeParaDto)
                .toList();
        return listaDto;
    }

    public VideoResponseDto cadastrar(VideoCadastroRequestDto dto) {
        Video entidade = new Video();

        BeanUtils.copyProperties(dto, entidade, "idCategoria");
        entidade.setCategoria(categoriaService.retornaCategoriaPorId(dto.idCategoria()));

        videoRepository.save(entidade);
        return VideoResponseDto.converteEntidadeParaDto(entidade);
    }

    public VideoResponseDto atualizar(Long id, VideoAtualizacaoRequestDto dto) {
        Video entidade = videoRepository.getReferenceById(id);
        entidade = VideoAtualizacaoRequestDto.atualizar(entidade, dto);

        entidade.setCategoria(categoriaService.retornaCategoriaPorId(dto.idCategoria()));

        return VideoResponseDto.converteEntidadeParaDto(videoRepository.save(entidade));
    }

    public void excluir(Long id) {
        videoRepository.deleteById(id);
    }

}
