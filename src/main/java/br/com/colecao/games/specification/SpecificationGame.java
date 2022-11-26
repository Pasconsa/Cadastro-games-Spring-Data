package br.com.colecao.games.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.colecao.games.orm.Game;

public class SpecificationGame {

	public static Specification<Game>nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
}
