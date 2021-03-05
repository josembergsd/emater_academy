package br.com.dnsistemas.academy.backend.repository;

import br.com.dnsistemas.academy.backend.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByNameContains(String name);
}
