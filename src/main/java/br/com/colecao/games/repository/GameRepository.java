package br.com.colecao.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.colecao.games.orm.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
List<Game> findByNome(String nome);

@Query("SELECT g FROM Game g WHERE g.nome = :nome AND g.produtora = :produtora AND g.anoLancamento >= :anoLancamento")
List <Game> findByNomeProdutoraAnoLancamentoGames (String nome, String produtora, int anoLancamento);
}
