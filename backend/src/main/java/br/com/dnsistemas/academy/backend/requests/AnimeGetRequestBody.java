package br.com.dnsistemas.academy.backend.requests;

import lombok.Data;

@Data
public class AnimeGetRequestBody {
    private Long id;
    private String name;
}
