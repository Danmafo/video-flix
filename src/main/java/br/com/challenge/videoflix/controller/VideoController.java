package br.com.challenge.videoflix.controller;

import br.com.challenge.videoflix.dto.request.VideoRequestDto;
import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.service.VideoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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

    @PostMapping
    public ResponseEntity<VideoResponseDto> cadastrar(@RequestBody @Valid VideoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

}
