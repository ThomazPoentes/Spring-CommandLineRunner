package br.com.thomaz.screnmatch;

import br.com.thomaz.screnmatch.Service.ConsumoAPI;
import br.com.thomaz.screnmatch.Service.ConvertDados;
import br.com.thomaz.screnmatch.model.DadosEpisodios;
import br.com.thomaz.screnmatch.model.DadosSerie;
import br.com.thomaz.screnmatch.model.DadosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScrenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmatchApplication.class, args);
	}
	ConsumoAPI consumoAPI = new ConsumoAPI();

	@Override
	public void run(String... args) throws Exception {

		String retornoJson = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		String coffe = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println("Teste Thomaz");
		System.out.println("");
		System.out.println(retornoJson);
		System.out.println("");
		System.out.println(coffe);

		ConvertDados conversor = new ConvertDados();
		DadosSerie dadosSerie = conversor.obterDados(retornoJson, DadosSerie.class);
		System.out.println(dadosSerie);
		System.out.println("");

		retornoJson = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodios dadosEpisodio = conversor.obterDados(retornoJson, DadosEpisodios.class);
		System.out.println(dadosEpisodio);
		System.out.println("");

		retornoJson = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosTemporada dadosTemporada = conversor.obterDados(retornoJson, DadosTemporada.class);
		System.out.println(dadosEpisodio);
		System.out.println("");


		List<DadosTemporada> temporadas = new ArrayList<>();
		for(int i = 1; i<= dadosSerie.totalTemporadas(); i++) {
			retornoJson = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			DadosTemporada dadosTemporada1 = conversor.obterDados(retornoJson, DadosTemporada.class);
			temporadas.add(dadosTemporada1);
		}
		temporadas.forEach(System.out::println);
	}
}



