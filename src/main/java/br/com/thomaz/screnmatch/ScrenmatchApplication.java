package br.com.thomaz.screnmatch;

import br.com.thomaz.screnmatch.Service.ConsumoAPI;
import br.com.thomaz.screnmatch.Service.ConvertDados;
import br.com.thomaz.screnmatch.controller.Controller;
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

	@Override
	public void run(String... args) throws Exception {
		Controller controller = new Controller();
		controller.exibirMenu();
		controller.metodoGeral();
	}
}



