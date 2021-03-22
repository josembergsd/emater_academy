package br.com.dnsistemas.academy.backend.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot empty")
    private String name;
}
