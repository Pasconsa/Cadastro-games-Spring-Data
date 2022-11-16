package br.com.colecao.games.orm;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consoles")
public class Console {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String marca;
	private int anolancamento;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnolancamento() {
		return anolancamento;
	}
	public void setAnolancamento(int anolancamento) {
		this.anolancamento = anolancamento;
	}
	
	@Override
	public String toString() {
		return "Console [id=" + id + ", nome=" + nome + ", marca=" + marca + ", anolancamento=" + anolancamento + "]";
	}
	
	
	
	

}
