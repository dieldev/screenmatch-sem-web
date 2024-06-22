package com.br.streammatch;

import model.Serie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.ConsumoAPI;
import services.ConverteDados;

@SpringBootApplication
public class StreammatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreammatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore&apikey=9b7f796b");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		Serie dados = conversor.obterDados(json, Serie.class);
		System.out.println(dados);
	}
}
