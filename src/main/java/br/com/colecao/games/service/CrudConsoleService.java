package br.com.colecao.games.service;


import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Console;
import br.com.colecao.games.repository.ConsoleRepository;

@Service
public class CrudConsoleService {

	private Boolean system = true;
	private final ConsoleRepository consoleRepository;

	public CrudConsoleService(ConsoleRepository consoleRepository) {
		this.consoleRepository = consoleRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao Console executar");
			System.out.println("0 - sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualisar");
			System.out.println("4 - Deletar");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}

	}

	public void salvar(Scanner scanner) {
		System.out.println("nome console");
		String nome = scanner.nextLine().toUpperCase();     //UpperCase para ficar padrão a forma que é salvo.
        nome += scanner.nextLine().toUpperCase();
		Console console = new Console();
		console.setNome(nome);
		consoleRepository.save(console);
		System.out.println("Salvo");
	}

	public void atualizar(Scanner scanner) {
		System.out.println("id");
		int id = scanner.nextInt();
		System.out.println("Nome do console");
		String nome = scanner.nextLine().toUpperCase();     //UpperCase para ficar padrão a forma que é salvo.
        nome += scanner.nextLine().toUpperCase();
		
		Console console = new Console();
		console.setId(id);
		console.setNome(nome);
		consoleRepository.save(console);
		System.out.println("Atualizado");

	}
	
	
	public void visualizar( ) {
		Iterable<Console> consoles = consoleRepository.findAll();
		consoles.forEach(console->System.out.println(console));
	}
	
	
	public void deletar (Scanner scanner) {
		System.out.println("Digite ID");
		int id = scanner.nextInt();
		consoleRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
