package test;

import java.util.ArrayList;
import java.util.List;

import model.Tabela;

public class Jogos extends Tabela<Integer> {

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getNomeTabela() {
		return "games";
	}

	@Override
	public void setCamposTabela(List<Object> list) {
		setPk((Integer)list.get(0));
		setNome((String)list.get(1));
		
	}

	@Override
	public Tabela getNovoObjeto() {
		// TODO Auto-generated method stub
		return new Jogos();
	}

	@Override
	public String getNomePk() {
		// TODO Auto-generated method stub
		return "id";
	}

	@Override
	public List<Object> getCamposValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCamposNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isPkSerial() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> getNomeColuna() {
		List<String> game = new ArrayList();
		game.add("");
		return game;
	}

}
