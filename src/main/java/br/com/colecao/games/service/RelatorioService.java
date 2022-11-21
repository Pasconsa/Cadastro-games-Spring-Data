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
		System.out.println("1 - Buscar Game por nome");
		System.out.println("2 - Buscar Game por nome, produtora, ano de lancamento.");
		
		int action = sc.nextInt();
		
		switch (action) {
		case 1:
			pesquisaGameNome(sc);
			break;
		case 2:
			buscaGameNomeProdutotraAnoLancamento(sc);
			break;
		default:
			system = false;
			break;
		}
		}
		
	}

	private void pesquisaGameNome(Scanner sc) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = sc.next();
		
		List<Game> list = gameRepository.findByNome(nome);
		list.forEach(System.out::println);
		
	}
	
	
	private void buscaGameNomeProdutotraAnoLancamento(Scanner sc) {
		System.out.println("Qual nome de game deseja pesquisar");
		String nome = sc.next();
        
        System.out.println("Qual produtora de game deseja pesquisar");
		String produtora = sc.next();
		
		System.out.println("Qual ano de lancamento do game deseja pesquisar");
		int ano = sc.nextInt();
		
		List<Game> list = gameRepository.findByNomeProdutoraAnoLancamentoGames(nome, produtora, ano);
		list.forEach(System.out::println);
        
	}

}
