package controle;

import java.util.ArrayList;
import java.util.List;

import modelo.Jogos;
import modelo.Tabela;

public class Controle extends CrudControle {

	public boolean ValidarCasoDeUso(String action) {
		List<String> acoesValidas = new ArrayList<>();
		acoesValidas.add("Select");
		acoesValidas.add("Remove");
		acoesValidas.add("Update");
		acoesValidas.add("Create");
		acoesValidas.add("Compare");
		for (int i = 0; i < acoesValidas.size(); i++) {
			if (acoesValidas.get(i).equals(action) == true) {
				return true;
			}
		}
		return false;
	}

	public <T extends Tabela<?>,U extends Tabela<?>,V extends Tabela<?>> ArrayList<Object> executar(String action, T tabela, U tabela2, V tabela3) {
		if (ValidarCasoDeUso(action) == true) {
			switch (action) {
			case "Select":
				return Select(tabela);
			case "Create":
				Create(tabela2);
				return null;
			case "Update":
				Update(tabela2);
				return null;
			case "Remove":
				Remove(tabela2);
				return null;
			case "Compare":
				return SelectCompare(tabela, tabela2, tabela3);
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	public <T extends Tabela<?>,U extends Tabela<?>,V extends Tabela<?>> ArrayList<Object> SelectCompare(T tabela, U tabela2, V tabela3) {
		ArrayList<T> lista = dao.listar(tabela);
		ArrayList<U> lista2 = dao.listar(tabela2);
		ArrayList<V> lista3 = dao.listar(tabela3);
		ArrayList<Object> retorno = new ArrayList<>();
		for (int i = 0; i < lista2.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				for (int k = 0; k < lista3.size(); k++) {
					if (lista2.get(i).getCamposValor().get(0) == lista.get(j).getCamposValor().get(0)
							&& lista2.get(i).getCamposValor().get(1) == lista3.get(k).getCamposValor().get(0)) {
						retorno.add(lista.get(j).getCamposValor().get(1).toString()+","+lista3.get(k).getCamposValor().get(1).toString());
					}
				}
			}
		}
		return retorno;
	}
}
