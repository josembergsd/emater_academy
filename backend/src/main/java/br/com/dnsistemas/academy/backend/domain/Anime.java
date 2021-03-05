package br.com.dnsistemas.academy.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //Gera get and setter, equals, hashcode e toString
@AllArgsConstructor //Gera construtor
@NoArgsConstructor
@Entity
@Builder
public class Anime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
