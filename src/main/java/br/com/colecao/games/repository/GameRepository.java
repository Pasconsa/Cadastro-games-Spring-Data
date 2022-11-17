package br.com.colecao.games.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.colecao.games.orm.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
