package br.com.colecao.games.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "midia")
public class MidiaFisica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoMidia;
	
	@OneToMany(mappedBy = "midiaFisica")
	private List <Game> game;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoMidia() {
		return tipoMidia;
	}
	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	
	public List<Game> getGame() {
		return game;
	}
	public void setGame(List<Game> game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		return "MidiaFisica [id=" + id + ", tipoMidia=" + tipoMidia + "]";
	}
	
	
	

	
	
	
	
	
	

	
	
	

}
