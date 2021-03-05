package br.com.dnsistemas.academy.backend.services;

import br.com.dnsistemas.academy.backend.domain.Anime;
import br.com.dnsistemas.academy.backend.exception.BadRequestException;
import br.com.dnsistemas.academy.backend.mapper.AnimeMapper;
import br.com.dnsistemas.academy.backend.repository.AnimeRepository;
import br.com.dnsistemas.academy.backend.requests.AnimePostRequestBody;
import br.com.dnsistemas.academy.backend.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Job rules
 */
@Service
@RequiredArgsConstructor  //Injeção de dependências
public class AnimeService {

    private final AnimeRepository animeRepository;

    //private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByNameContains(name);
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        //Verifica se o anime existe
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}