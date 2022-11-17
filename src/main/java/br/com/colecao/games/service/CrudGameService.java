package br.com.colecao.games.service;


import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.colecao.games.orm.Console;
import br.com.colecao.games.orm.Game;
import br.com.colecao.games.orm.MidiaFisica;
import br.com.colecao.games.repository.ConsoleRepository;
import br.com.colecao.games.repository.GameRepository;
import br.com.colecao.games.repository.MidiaFisicaRepository;

@Service
public class CrudGameService {
	
	  private Boolean system = true;
	    
	    private final GameRepository gameRepository;
	    private final MidiaFisicaRepository midiaFisicaRepository;
	    private final ConsoleRepository consoleRepository;
	    
	    
	 
	    
	    public CrudGameService(GameRepository gameRepository, MidiaFisicaRepository midiaFisicaRepository,
				ConsoleRepository consoleRepository) {
			this.gameRepository = gameRepository;
			this.midiaFisicaRepository = midiaFisicaRepository;
			this.consoleRepository = consoleRepository;
		}

		public void inicial(Scanner sc) {
	        while(system) {
	            System.out.println("Qual acao para Game que deseja executar");
	            System.out.println("0 - Sair");
	            System.out.println("1 - Salvar");
	            System.out.println("2 - Atualizar");
	            System.out.println("3 - Visualizar");
	            System.out.println("4 - Deletar");
	            
	            int action = sc.nextInt();
	            
	            switch (action) {
	            case 1:
	                salvar(sc);
	                break;
	            case 2:
	                atualizar(sc);
	                break;
	            case 3:
	                visualizar();
	                break;
	            case 4:
	                deletar(sc);
	                break;
	            default:
	                system = false;
	                break;
	            }
	            
	        }
	        
	    }
	    
	    private void salvar(Scanner sc) {
	        System.out.println("Digite o nome");
	        String nome = sc.nextLine().toUpperCase();     
	        nome += sc.nextLine().toUpperCase();

	        System.out.println("Digite o produtora");
	        String produtora = sc.nextLine().toUpperCase();     
	        produtora += sc.nextLine().toUpperCase();

	        System.out.println("Digite o genero");
	        String genero = sc.nextLine().toUpperCase();     
	        genero += sc.nextLine().toUpperCase();

	        System.out.println("Digite o ano de lancamento 4 digitos");
	        int ano = sc.nextInt();

	        System.out.println("Digite o consoleId");
	        Integer consoleId = sc.nextInt();

	        System.out.println("Digite a MidiaId");
	        Integer midiaId = sc.nextInt();
	        
	        Game game = new Game();
	        game.setNome(nome);
	        game.setProdutora(produtora);
	        game.setGenêro(genero);
	        game.setAnoLancamento(ano);
	        Optional<Console> console = consoleRepository.findById(consoleId);
	        game.setConsole(console.get());
	        Optional<MidiaFisica> midia = midiaFisicaRepository.findById(midiaId);
	        game.setMidiaFisica(midia.get());
	       

	        gameRepository.save(game);
	        System.out.println("Salvo");
	    }
	    
	    
	    private void atualizar(Scanner sc) {
	        System.out.println("Digite o id");
	        Integer id = sc.nextInt();

	        System.out.println("Digite o nome");
	        String nome = sc.nextLine().toUpperCase();     
	        nome += sc.nextLine().toUpperCase();

	        System.out.println("Digite o produtora");
	        String produtora = sc.nextLine().toUpperCase();     
	        produtora += sc.nextLine().toUpperCase();

	        System.out.println("Digite o genero");
	        String genero = sc.nextLine().toUpperCase();     
	        genero += sc.nextLine().toUpperCase();

	        System.out.println("Digite o ano de lancamento 4 digitos");
	        int ano = sc.nextInt();

	        System.out.println("Digite o consoleId");
	        Integer consoleId = sc.nextInt();

	        System.out.println("Digite a MidiaId");
	        Integer midiaId = sc.nextInt();
	        
	        Game game = new Game();
	        game.setId(id);
	        game.setNome(nome);
	        game.setProdutora(produtora);
	        game.setGenêro(genero);
	        game.setAnoLancamento(ano);
	        Optional<Console> console = consoleRepository.findById(consoleId);
	        game.setConsole(console.get());
	        Optional<MidiaFisica> midia = midiaFisicaRepository.findById(midiaId);
	        game.setMidiaFisica(midia.get());
	       

	        gameRepository.save(game);
	        System.out.println("Alterado");
	    
	    }
	    
	    
	    private void visualizar() {
	    	Iterable<Game> games = gameRepository.findAll();
	        games.forEach(game -> System.out.println(game));
	    }

	    	
	    
	    private void deletar(Scanner sc) {
	        System.out.println("Id");
	        int id = sc.nextInt();
	       gameRepository.deleteById(id);
	        System.out.println("Deletado");
	    }
	    
	}


