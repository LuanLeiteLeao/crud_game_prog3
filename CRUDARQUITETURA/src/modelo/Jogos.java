package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Jogos extends Tabela<Integer> {

	private Integer id;
	private String nome;
	private String descricao;
	private Date data_lancamento;
	private Integer is_jogo_do_ano;
	private Date criacao;
	private Date modificacao;
	
	public Jogos(Integer id, String nome, String descricao,Date data_lancamento,Integer is_jogo_do_ano,Date criacao,Date modificacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data_lancamento = data_lancamento;
		this.is_jogo_do_ano = is_jogo_do_ano;
		this.criacao = criacao;
		this.modificacao = modificacao;
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

	@Override
	public String getNomeTabela() {
		return "games";
	}

	@Override
	public void setCamposTabela(List<Object> list) {
		setId((Integer) list.get(0));
		setNome((String) list.get(1));
		setDescricao((String) list.get(2));
		setData_lancamento((Date) list.get(3));
		setIs_jogo_do_ano((Integer) list.get(4));
		setCriacao((Date) list.get(5));
		setModificacao((Date) list.get(6));

	}

	@Override
	public Tabela getNovoObjeto() {
		// TODO Auto-generated method stub
		return new Jogos(id, descricao, descricao, criacao, id, criacao, modificacao);
	}

	@Override
	public String getNomePk() {
		// TODO Auto-generated method stub
		return "id";
	}

	@Override
	public List<Object> getCamposValor() {
		List<Object> campos = new ArrayList<>();
		campos.add(id);
		campos.add(nome);
		campos.add(descricao);
		campos.add(data_lancamento);
		campos.add(is_jogo_do_ano);
		campos.add(criacao);
		campos.add(modificacao);
		return campos;
	}

	@Override
	public List<String> getCamposNome() {
		List<String> campos = new ArrayList<>();
		campos.add("id");
		campos.add("nome");
		campos.add("descricao");
		campos.add("data_lancamento");
		campos.add("is_jogo_do_ano");
		campos.add("criacao");
		campos.add("modificacao");
		return campos;
	}

	@Override
	public Boolean isPkSerial() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getCamposNomeStr() {
		List<String> listcampos = getCamposNome();
		String campos = new String();
		for (int i = 0; i < listcampos.size(); i++) {
			campos = campos.concat(listcampos.get(i) + ",");
		}
		campos = campos.substring(0, campos.length() - 1);
		return campos;
	}

}
