package modelo;

import java.util.ArrayList;
import java.util.List;

public class Games_has_generos extends Tabela<Integer> {

	private Integer games_id;
	private Integer generos_id;
	
	public Integer getGames_id() {
		return games_id;
	}

	public void setGames_id(Integer gamesid) {
		this.games_id = gamesid;
	}

	public Integer getGeneros_id() {
		return generos_id;
	}

	public void setGeneros_id(Integer generosid) {
		this.generos_id = generosid;
	}
	
	@Override
	public String getNomeTabela() {
		return "Games_has_generos";
	}

	@Override
	public void setCamposTabela(List<Object> list) {
		setGames_id((Integer)list.get(0));
		setGeneros_id((Integer)list.get(1));
	}

	@Override
	public Tabela getNovoObjeto() {
		// TODO Auto-generated method stub
		return new Games_has_generos();
	}

	@Override
	public String getNomePk() {
		// TODO Auto-generated method stub
		return "games_id";
	}

	@Override
	public List<Object> getCamposValor() {
		List<Object> campos = new ArrayList<>();
		campos.add(games_id);
		campos.add(generos_id);
		return campos;
	}

	@Override
	public List<String> getCamposNome() {
		List<String> campos = new ArrayList<>();
		campos.add("games_id");
		campos.add("generos_id");
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
		for (int i=0;i<listcampos.size(); i++) {
			campos=campos.concat(listcampos.get(i)+",");
		}
		campos=campos.substring(0,campos.length()-1);
		return campos;
	}

}
