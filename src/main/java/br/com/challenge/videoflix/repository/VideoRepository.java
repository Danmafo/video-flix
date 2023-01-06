package br.com.challenge.videoflix.repository;

import br.com.challenge.videoflix.entity.Video;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByCategoria_Id(Long id);

    List<Video> findByTituloContainingIgnoreCase(String pesquisa);

}
