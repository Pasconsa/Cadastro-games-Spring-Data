package br.com.colecao.games.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Game;
import br.com.colecao.games.repository.GameRepository;
import br.com.colecao.games.specification.SpecificationGame;

@Service
public class RelatorioGameDinamico {
	
	private final GameRepository gameRepository;

	
	public RelatorioGameDinamico(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	
	public void inicial (Scanner scanner) {
		
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		
		System.out.println("Digite a produtora");
		String produtora = scanner.next();
		
		if(produtora.equalsIgnoreCase("NULL")) {
			produtora = null;
		}
		
	
		System.out.println("Digite o genero ");
		String genero = scanner.next();
		
		if(genero.equalsIgnoreCase("NULL")) {
			genero = null;
		}
		
		
		System.out.println("Digite o ano de lançamento");
		int anoLancamento = scanner.nextInt();
		
		//observar esta estrutura testar
		if(anoLancamento == 0) {
			anoLancamento = (Integer) null;
		}
		
		
		List<Game> games = gameRepository.findAll(Specification
				.where
						(SpecificationGame.nome(nome))
						.or(SpecificationGame.produtora(produtora))
						.or(SpecificationGame.genero(genero))
						.or(SpecificationGame.dataLancamento(anoLancamento))
				);
		games.forEach(System.out::println);
	}
	

}
