package br.com.colecao.games.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "midia")
public class MidiaFisica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoMidia;
	
	
	
	public synchronized Integer getId() {
		return id;
	}
	public synchronized void setId(Integer id) {
		this.id = id;
	}
	public synchronized String getTipoMidia() {
		return tipoMidia;
	}
	public synchronized void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	
	@Override
	public String toString() {
		return "MidiaFisica [id=" + id + ", tipoMidia=" + tipoMidia + "]";
	}
	
	

	
	
	
	
	
	

	
	
	

}
