package br.com.thomaz.screnmatch;

import br.com.thomaz.screnmatch.Service.ConsumoAPI;
import br.com.thomaz.screnmatch.Service.ConvertDados;
import br.com.thomaz.screnmatch.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		String retornoJson = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		String coffe = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println("Teste Thomaz");
		System.out.println("");
		System.out.println(retornoJson);
		System.out.println("");
		System.out.println(coffe);


		ConvertDados conversor = new ConvertDados();
		DadosSerie dados = conversor.obterDados(retornoJson, DadosSerie.class);
		System.out.println(dados);
	}
}
