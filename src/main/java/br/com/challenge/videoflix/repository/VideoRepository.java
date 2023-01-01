package br.com.challenge.videoflix.repository;

import br.com.challenge.videoflix.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
