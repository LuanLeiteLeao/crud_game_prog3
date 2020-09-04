package test;

import java.util.List;

import model.DAOGeneric;
import model.Tabela;

public class Pessoa extends Tabela {
	
	private Integer nomeAmigo;
	private Integer telefone;
	
	@Override
	public Tabela getNovoObjeto() {
		
		return new Pessoa();
	}
	

	public static void main(String[] args) {
		DAOGeneric dao = new DAOGeneric();
		Pessoa gam = new Pessoa();
	

	dao.listar(gam);
		
	}


	@Override
	protected void setCamposValor(List<Object> list) {
		// TODO Auto-generated method stub
		
	}



	
}

