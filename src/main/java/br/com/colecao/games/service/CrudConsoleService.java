package br.com.colecao.games.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Console;
import br.com.colecao.games.repository.ConsoleRepository;

@Service
public class CrudConsoleService {

	private final ConsoleRepository consoleRepository;

	public CrudConsoleService(ConsoleRepository consoleRepository) {
		this.consoleRepository = consoleRepository;
	}
		
	public void inicial(Scanner scanner) {
		salvar(scanner);
	}
	
	
	public void salvar (Scanner scanner) {
		System.out.println("Nome do Console");
		String nome = scanner.next();
		Console console = new Console();
		console.setNome(nome);
		consoleRepository.save(console);
		System.out.println("Salvo");
	}
		
}
