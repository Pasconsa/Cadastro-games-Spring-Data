package br.com.colecao.games;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.colecao.games.orm.Console;
import br.com.colecao.games.repository.ConsoleRepository;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner{
	
	private final ConsoleRepository repository;

	public GamesApplication(ConsoleRepository repository) {
		this.repository = repository;
	}



	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Console console = new Console();
		console.setNome("Nintendo");
		
		repository.save(console);
		
	}

}
