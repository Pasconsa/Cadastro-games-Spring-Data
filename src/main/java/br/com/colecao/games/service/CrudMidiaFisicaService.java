package br.com.colecao.games.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.MidiaFisica;
import br.com.colecao.games.repository.MidiaFisicaRepository;

@Service
public class CrudMidiaFisicaService {

	private final MidiaFisicaRepository midiaFisicaRepository;
	public boolean system = true;

	public CrudMidiaFisicaService(MidiaFisicaRepository midiaFisicaRepository) {
		this.midiaFisicaRepository = midiaFisicaRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao tipo Midia executar");
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
			System.out.println("Qual o tipo da midia");
			String tipo =scanner.nextLine().toUpperCase();     
			tipo += scanner.nextLine().toUpperCase();
			
			MidiaFisica midia = new MidiaFisica();
			midia.setTipoMidia(tipo);
			
			midiaFisicaRepository.save(midia);
			System.out.println("Salvo");
		}

		public void atualizar(Scanner scanner) {
			System.out.println("id");
			int id = scanner.nextInt();
			System.out.println("Qual o tipo da midia");
			String tipo =scanner.nextLine().toUpperCase();     
			tipo += scanner.nextLine().toUpperCase();
			
			MidiaFisica midia = new MidiaFisica();
			midia.setId(id);
			midia.setTipoMidia(tipo);
			
			midiaFisicaRepository.save(midia);
			System.out.println("Atualizado");
		}
		
		
		public void visualizar( ) {
			Iterable<MidiaFisica> midias = midiaFisicaRepository.findAll();
			midias.forEach(midia->System.out.println(midia));
		}
		
		
		public void deletar (Scanner scanner) {
			System.out.println("Digite ID");
			int id = scanner.nextInt();
			midiaFisicaRepository.deleteById(id);
			System.out.println("Deletado");
		}

}
