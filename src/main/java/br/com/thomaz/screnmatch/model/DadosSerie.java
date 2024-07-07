package br.com.thomaz.screnmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("imdbRating")  String totalTemporadas,
                         @JsonAlias("totalSeasons") String avaliacao,
                         @JsonProperty("imdbVotes") String votos) {
}
