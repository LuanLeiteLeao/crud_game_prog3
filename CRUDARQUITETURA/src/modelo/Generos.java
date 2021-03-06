package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Generos extends Tabela<Integer> {

	private Integer id;
	private String nome;
	
	public Generos(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	@Override
	public String getNomeTabela() {
		return "Generos";
	}

	@Override
	public void setCamposTabela(List<Object> list) {
		setId((Integer)list.get(0));
		setNome((String)list.get(1));
		
	}

	@Override
	public Tabela getNovoObjeto() {
		// TODO Auto-generated method stub
		return new Generos(id, nome);
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
		return campos;
	}

	@Override
	public List<String> getCamposNome() {
		List<String> campos = new ArrayList<>();
		campos.add("id");
		campos.add("nome");
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
