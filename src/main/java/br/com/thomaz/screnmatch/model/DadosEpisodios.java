package br.com.thomaz.screnmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String tituloEpisodio,
                             @JsonAlias("Episode") String numeroEpisodio,
                             @JsonAlias("imdbRating") String avaliacaoEpisodio,
                             @JsonAlias("Released") String dataLancamentoEpisodio) {
}
