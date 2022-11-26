package br.com.colecao.games.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Game;
import br.com.colecao.games.repository.GameRepository;
import br.com.colecao.games.specification.SpecificationGame;

public class RelatorioGameDinamico {
	
	private final GameRepository gameRepository;

	
	public RelatorioGameDinamico(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	
	public void inicial (Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		List<Game> games = gameRepository.findAll(Specification.where(SpecificationGame.nome(nome)));
	}
	

}
