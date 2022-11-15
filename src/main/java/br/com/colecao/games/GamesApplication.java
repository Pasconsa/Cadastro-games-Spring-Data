package br.com.colecao.games;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.colecao.games.orm.Console;
import br.com.colecao.games.repository.ConsoleRepository;
import br.com.colecao.games.service.CrudConsoleService;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner{
	
	private final CrudConsoleService consoleService;
	
	private boolean system = true;


	public GamesApplication(CrudConsoleService consoleService) {
		this.consoleService = consoleService;
	}



	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - sair");
			System.out.println("1 - Console");
		
		
		int acao = sc.nextInt();
		if(acao == 1) {
			consoleService.inicial(sc);
		} else {
			system = false;
		}
		
		}
	}

}
