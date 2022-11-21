package br.com.colecao.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.colecao.games.orm.Game;

//Derived Query
public interface GameRepository extends CrudRepository<Game, Integer> {
List<Game> findByNome(String nome);

//Jpql Query
@Query("SELECT g FROM Game g WHERE g.nome = :nome AND g.produtora = :produtora AND g.anoLancamento = :anoLancamento")
List <Game> findByNomeProdutoraAnoLancamentoGames (String nome, String produtora, int anoLancamento);

//Native Query
@Query(value = "SELECT * FROM games g WHERE g.ano_lancamento >= :anoLancamento", nativeQuery = true)
List <Game> findAnoLancamentoMaior(int anoLancamento);


}

