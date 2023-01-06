package br.com.challenge.videoflix.controller;

import br.com.challenge.videoflix.dto.request.VideoAtualizacaoRequestDto;
import br.com.challenge.videoflix.dto.request.VideoCadastroRequestDto;
import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    VideoService service;

    @GetMapping
    public ResponseEntity<List<VideoResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<VideoResponseDto>> buscarPorCategoriaId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorIdCategoria(id));
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<VideoResponseDto>> buscarPorTituloPesquisa(@RequestParam String pesquisa) {
        return ResponseEntity.ok(service.buscarPorTituloPesquisa(pesquisa));
    }

    @PostMapping
    public ResponseEntity<VideoResponseDto> cadastrar(@RequestBody @Valid VideoCadastroRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponseDto> atualizar(@PathVariable Long id, @RequestBody @Valid VideoAtualizacaoRequestDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
