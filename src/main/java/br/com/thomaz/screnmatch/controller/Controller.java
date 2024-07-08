package br.com.thomaz.screnmatch.controller;

import br.com.thomaz.screnmatch.Service.ConsumoAPI;
import br.com.thomaz.screnmatch.Service.ConvertDados;
import br.com.thomaz.screnmatch.model.DadosEpisodios;
import br.com.thomaz.screnmatch.model.DadosSerie;
import br.com.thomaz.screnmatch.model.DadosTemporada;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Scanner leitura = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertDados conversor = new ConvertDados();


    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY_FIRST = "6585022c";
    private final String API_KEY_SECONDARY = "&apikey=6585022c";
    private final String BASEURL = "https://www.omdbapi.com/";
    private final String retornoJson = consumoAPI.obterDados(BASEURL + "?t=gilmore+girls&apikey=" + API_KEY_FIRST);


    public void exibirMenu(){
        System.out.println("Digite o nome da série para a busca");
        var nomeSerie = leitura.nextLine();
        var json = consumoAPI.obterDados(ENDERECO + nomeSerie.replace("", "+") + API_KEY_SECONDARY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

    }

    public void metodoGeral(){
        try {
            String coffee = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");

            System.out.println("Teste Thomaz");
            System.out.println();
            System.out.println(retornoJson);
            System.out.println();
            System.out.println(coffee);

            ConvertDados conversor = new ConvertDados();

            DadosSerie dadosSerie = obterDadosSerie(BASEURL, API_KEY_FIRST, conversor);
            System.out.println(dadosSerie);
            System.out.println();

            DadosEpisodios dadosEpisodio = obterDadosEpisodio(BASEURL, API_KEY_FIRST, conversor);
            System.out.println(dadosEpisodio);
            System.out.println();

            DadosTemporada dadosTemporada = obterDadosTemporada(BASEURL, API_KEY_FIRST, conversor);
            System.out.println(dadosTemporada);
            System.out.println();

            List<DadosTemporada> temporadas = obterDadosTemporadas(BASEURL, API_KEY_FIRST, conversor, dadosSerie.totalTemporadas());
            temporadas.forEach(System.out::println);



        } catch (IOException e) {
            System.err.println("Erro ao consumir API: " + e.getMessage());
        }
    }


    private DadosSerie obterDadosSerie(String baseUrl, String apiKey, ConvertDados conversor) throws IOException {
        var json = consumoAPI.obterDados(baseUrl + "?t=gilmore+girls&apikey=" + apiKey);
        return conversor.obterDados(retornoJson, DadosSerie.class);
    }

    private DadosEpisodios obterDadosEpisodio(String baseUrl, String apiKey, ConvertDados conversor) throws IOException {
        String retornoJson = consumoAPI.obterDados(baseUrl + "?t=gilmore+girls&season=1&episode=2&apikey=" + apiKey);
        return conversor.obterDados(retornoJson, DadosEpisodios.class);
    }

    private DadosTemporada obterDadosTemporada(String baseUrl, String apiKey, ConvertDados conversor) throws IOException {
        String retornoJson = consumoAPI.obterDados(baseUrl + "?t=gilmore+girls&season=1&episode=2&apikey=" + apiKey);
        return conversor.obterDados(retornoJson, DadosTemporada.class);
    }

    private List<DadosTemporada> obterDadosTemporadas(String baseUrl, String apiKey, ConvertDados conversor, int totalTemporadas) throws IOException {
        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= totalTemporadas; i++) {
            String retornoJson = consumoAPI.obterDados(baseUrl + "?t=gilmore+girls&season=" + i + "&apikey=" + apiKey);
            DadosTemporada dadosTemporada = conversor.obterDados(retornoJson, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        return temporadas;
    }
}

