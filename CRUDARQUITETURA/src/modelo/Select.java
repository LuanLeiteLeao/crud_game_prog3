package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Select {

	private Integer id;
	private String nome;
	private String descricao;
	private Date data_lancamento;
	private Integer is_jogo_do_ano;
	private Date criacao;
	private Date modificacao;
	private ArrayList<String> genero;
	private ArrayList<String> plataforma;
	
	public Select(Integer id, String nome, String descricao,Date data_lancamento,Integer is_jogo_do_ano,Date criacao, Date modificacao,ArrayList<String> genero,ArrayList<String> plataforma) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data_lancamento = data_lancamento;
		this.is_jogo_do_ano = is_jogo_do_ano;
		this.criacao = criacao;
		this.modificacao = modificacao;
		this.genero = genero;
		this.plataforma = plataforma;
	}
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public Integer getIs_jogo_do_ano() {
		return is_jogo_do_ano;
	}

	public void setIs_jogo_do_ano(Integer is_jogo_do_ano) {
		this.is_jogo_do_ano = is_jogo_do_ano;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getModificacao() {
		return modificacao;
	}

	public void setModificacao(Date modificacao) {
		this.modificacao = modificacao;
	}
	
	public ArrayList<String> getGenero() {
		return genero;
	}

	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}

	public ArrayList<String> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(ArrayList<String> plataforma) {
		this.plataforma = plataforma;
	}
}
