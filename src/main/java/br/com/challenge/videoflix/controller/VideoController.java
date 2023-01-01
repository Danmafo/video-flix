package br.com.challenge.videoflix.controller;

import br.com.challenge.videoflix.dto.response.VideoResponseDto;
import br.com.challenge.videoflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
