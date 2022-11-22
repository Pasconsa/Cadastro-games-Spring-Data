package br.com.colecao.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.colecao.games.orm.Game;
import br.com.colecao.games.orm.GameProdutoraProjecao;

@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Integer>, JpaSpecificationExecutor<Game> {

//Derived Query	
List<Game> findByNome(String nome);

//Jpql Query
@Query("SELECT g FROM Game g WHERE g.nome = :nome AND g.produtora = :produtora AND g.anoLancamento = :anoLancamento")
List <Game> findByNomeProdutoraAnoLancamentoGames (String nome, String produtora, int anoLancamento);

//Native Query
@Query(value = "SELECT * FROM games g WHERE g.ano_lancamento >= :anoLancamento", nativeQuery = true)
List <Game> findAnoLancamentoMaior(int anoLancamento);

//Native Query
//Projeção atrbutos minha escolha
@Query (value = "SELECT g.id, g.nome, g.produtora FROM games g", nativeQuery = true)
	List<GameProdutoraProjecao> findGameProdutora();

}

