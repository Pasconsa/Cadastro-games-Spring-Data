package br.com.colecao.games;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.colecao.games.service.CrudConsoleService;
import br.com.colecao.games.service.CrudGameService;
import br.com.colecao.games.service.CrudMidiaFisicaService;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner {

	private final CrudConsoleService consoleService;
	private final CrudMidiaFisicaService midiaFisicaService;
	private final CrudGameService gameService;

	private boolean system = true;

	public GamesApplication(CrudConsoleService consoleService, CrudMidiaFisicaService midiaFisicaService, CrudGameService gameService) {
		this.consoleService = consoleService;
		this.midiaFisicaService = midiaFisicaService;
		this.gameService = gameService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - sair");
			System.out.println("1 - Console");
			System.out.println("2 - Tipo Midia");
			System.out.println("3 - Game");

			Integer function = sc.nextInt();

			switch (function) {
			case 1:
				consoleService.inicial(sc);
				break;
			case 2:
				midiaFisicaService.inicial(sc);
				break;
			case 3:
				gameService.inicial(sc);
				break;
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}

		}
	}
}
