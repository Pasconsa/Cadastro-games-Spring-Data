package br.com.colecao.games.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.colecao.games.orm.Console;

public interface ConsoleRepository extends CrudRepository<Console, Integer> {

}
