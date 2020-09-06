package test;

import java.util.ArrayList;
import java.util.List;

import model.DAOGeneric;
import model.Tabela;

public class Pessoa extends Tabela {

	private Integer id;
	private String nome;
	private String sobreNome;
	private Integer idade;
	private Integer petFk;

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
	protected String getNomeTabela() {

		return "pessoa";
	}

	@Override
	public void setCamposTabela(List<Object> list) {

		setId((Integer) list.get(0));
		setNome((String) list.get(1));
		setSobreNome((String) list.get(2));
		setIdade((Integer) list.get(3));
		setPetFk((Integer) list.get(4));
	}

	@Override
	public Tabela getNovoObjeto() {

		return new Pessoa();
	}


	public static void main(String[] args) {
		Pessoa pes = new Pessoa();
		DAOGeneric dao = new DAOGeneric();

		ArrayList<Pessoa> list = dao.listar(pes);

		for (Pessoa pessoa : list) {
			System.out.println(pessoa.getNome() + "" + pessoa.getId() + "" + pessoa.getIdade() + ""
					+ pessoa.getSobreNome() + "" + pessoa.getPetFk());
		}
	}

}
