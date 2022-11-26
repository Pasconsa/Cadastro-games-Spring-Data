package br.com.colecao.games.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.colecao.games.orm.Game;

public class SpecificationGame {

	public static Specification<Game>nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Game>produtora(String produtora) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("produtora"), produtora);
	}
	
	public static Specification<Game>genero(String genero) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("genero"), genero);
	}
	
	public static Specification<Game>dataLancamento(int dataLancamento) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("anoLancamento"), dataLancamento);
	}
	
}
