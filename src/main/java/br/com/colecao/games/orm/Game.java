package br.com.colecao.games.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome ;
	private String produtora;
	private String genero;
	private int anoLancamento;
	
	@ManyToOne
	@JoinColumn(name = "midia_Id", nullable = false)
	private MidiaFisica midiaFisica;
	
	@ManyToOne
	@JoinColumn(name = "console_Id", nullable = false)
	private Console console;
	
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
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public String getGenêro() {
		return genero;
	}
	public void setGenêro(String genêro) {
		this.genero = genêro;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public MidiaFisica getMidiaFisica() {
		return midiaFisica;
	}
	public void setMidiaFisica(MidiaFisica midiaFisica) {
		this.midiaFisica = midiaFisica;
	}
	public Console getConsole() {
		return console;
	}
	public void setConsole(Console console) {
		this.console = console;
	}
	
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", nome=" + nome + ", produtora=" + produtora + ", genero=" + genero
				+ ", anoLancamento=" + anoLancamento + ", midiaFisica=" + midiaFisica + ", console=" + console + "]";
	}
	
	

	
	
	
	
	
	
	
	

}
