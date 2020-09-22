package controle;

import java.util.ArrayList;

import modelo.Jogos;
import modelo.Tabela;
import persistencia.DAOGeneric;

public class CrudControle {

	DAOGeneric dao = new DAOGeneric();

	public <T extends Tabela<?>> ArrayList<Object> Select(T tabela) {
		ArrayList<T> lista = dao.listar(tabela);
		ArrayList<Object> retorno = new ArrayList<>();
		for (T linha:lista) {
			retorno.add(linha);
		}
		return retorno;
	}

	public <T extends Tabela<?>> void Create(T tabela) {
		tabela.setPk(tabela.getCamposValor().get(0));
		dao.inserir(tabela);
	}

	public <T extends Tabela<?>> void Update(T tabela) {
		tabela.setPk(tabela.getCamposValor().get(0));
		dao.atualizar(tabela);
	}

	public <T extends Tabela<?>> void Remove(T tabela) {
		tabela.setPk(tabela.getCamposValor().get(0));
		dao.remover(tabela);
	}

}
