package br.com.dnsistemas.academy.backend.mapper;

import br.com.dnsistemas.academy.backend.domain.Anime;
import br.com.dnsistemas.academy.backend.requests.AnimePostRequestBody;
import br.com.dnsistemas.academy.backend.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    //Cria uma instancia da classe AnimeMapper
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
