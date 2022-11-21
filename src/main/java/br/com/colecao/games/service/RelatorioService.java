package br.com.colecao.games.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Game;
import br.com.colecao.games.repository.GameRepository;

@Service
public class RelatorioService {
	
	private Boolean system = true;
	private final GameRepository gameRepository ;
	
	
	public RelatorioService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	

	public void inicial (Scanner sc) {
		while(system) {
		System.out.println("O que desejo pesquisar em GAME");
		System.out.println("0 - Sair");
		System.out.println("1 - Pesquisar Game por nome");
		
		int action = sc.nextInt();
		
		switch (action) {
		case 1:
			pesquisaGameNome(sc);
			break;
		default:
			system = false;
			break;
		}
		}
		
	}

	private void pesquisaGameNome(Scanner sc) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = sc.nextLine().toUpperCase();     
        nome += sc.nextLine().toUpperCase();
		List<Game> list = gameRepository.findByNome(nome);
		list.forEach(System.out::println);
		
	}

}
