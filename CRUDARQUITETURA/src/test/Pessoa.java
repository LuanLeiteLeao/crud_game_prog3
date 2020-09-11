package test;

import java.util.ArrayList;
import java.util.List;

import model.DAOGeneric;
import model.Tabela;

public class Pessoa extends Tabela<Integer> {

	private String nome;
	private String sobreNome;
	private Integer idade;
	private Integer petFk;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobre_nome) {
		this.sobreNome = sobre_nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getPetFk() {
		return petFk;
	}

	public void setPetFk(Integer petFk) {
		this.petFk = petFk;
	}

	@Override
	public String getNomeTabela() {

		return "pessoa";
	}

	@Override
	public void setCamposTabela(List<Object> list) {

		setPk((Integer) list.get(0));
		setNome((String) list.get(1));
		setSobreNome((String) list.get(2));
		setIdade((Integer) list.get(3));
		setPetFk((Integer) list.get(4));
	}

	@Override
	public Tabela getNovoObjeto() {

		return new Pessoa();
	}

	@Override
	public String getNomePk() {
		return "id";
	}

	@Override
	public List<Object> getCamposValor() {
		List<Object> list = new ArrayList<>();
		list.add(getPk());
		list.add(getNome());
		list.add(getSobreNome());
		list.add(getIdade());
		list.add(getPetFk());
		return list;
	}

	@Override
	public List<String> getCamposNome() {
		List<String> list = new ArrayList<>();
		list.add("id");
		list.add("nome");
		list.add("sobre_nome");
		list.add("idade");
		list.add("pet");
		return list;
	}
	
	@Override
	public String getNomeColuna() {
		String game = "id,nome,descricao,data_lancamento,is_jogo_do_ano,criacao,modificacao";
		return game;
	}

	@Override
	public Boolean isPkSerial() {
		return true;
	}
	
	public static void main(String[] args) {
		Pessoa pes = new Pessoa();
		DAOGeneric dao = new DAOGeneric();
		
		Pessoa p = new Pessoa();
		
		p.setNome("Galinha");
		p.setSobreNome("Leite");
		p.setIdade(19);
		p.setPetFk(2);
		
		ArrayList<Pessoa> a = dao.listar(pes);
		a.get(0).setNome("Galinha LOka");
		//dao.inserir(p);
		dao.atualizar(a.get(0));
	}


	

}
