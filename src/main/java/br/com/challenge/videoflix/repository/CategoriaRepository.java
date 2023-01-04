package br.com.challenge.videoflix.repository;

import br.com.challenge.videoflix.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
