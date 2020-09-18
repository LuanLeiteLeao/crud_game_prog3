package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mensagem.Mensagem;
import mensagem.PersistenciaMensagem;
import modelo.Tabela;

public class DAOGeneric extends DAOConexao {
	private PersistenciaMensagem mensagem = new PersistenciaMensagem();

	public DAOGeneric() {
		super();

	}

	private List<Object> getCamposValores(ResultSet rs) throws SQLException {
		ArrayList<Object> list = new ArrayList<>();
		int columnCount = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			list.add(rs.getObject(i));
		}
		return list;
	}

	public <T extends Tabela<?>> ArrayList<T> listar(T tabela) {
//		nao é bom passar *, nao é uma boa pratica
//		passar a lista de campos, pois aordem de campos pode mudar
		//String sqlSelect = "select " + tabela.getCamposNomeStr() + " from " + tabela.getNomeTabela();
		String sqlSelect = "select " + tabela.getCamposNomeStr() + " from " + tabela.getNomeTabela();
		ArrayList<T> lista = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.con.prepareStatement(sqlSelect);

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet

			while (rs.next()) {
				T auxTab = (T) tabela.getNovoObjeto();
				auxTab.setCamposTabela(this.getCamposValores(rs));
				lista.add(auxTab);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public <T extends Tabela<?>> String atualizar(T tabela) {
		PreparedStatement stmt;
		if (tabela.getPk() == null) {
			System.out.println("Erro ao atualizar ID nulo");
			return "ID nulo";
		}

		String sql = "UPDATE  " + tabela.getNomeTabela() + " SET " + prepararNomeCampoAtualizar(tabela) + " WHERE "
				+ tabela.getNomePk() + "=" + tabela.getPk();
		try {
			stmt = (PreparedStatement) this.con.prepareStatement(sql);
			System.out.println(sql);
			// executa um select

			stmt.execute();
			System.out.println("Deu Bom , objeto update");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu Ruim , objeto update");
			e.printStackTrace();
		}
		return "";

	}

	public <T extends Tabela<?>> String prepararNomeCampoAtualizar(T tabela) {
		List<String> camposNome = tabela.getCamposNome();
		List<Object> camposValor = tabela.getCamposValor();
		int indice = 0;
		String formato = "";
		if (camposNome.size() != camposValor.size()) {
			return "os metodos getCamposNome() e tabela.getCamposValor() não foram preenchidos da maneira correta pois não contem o mesmo tamanho";
		}
		
		if (tabela.isPkSerial()) {
			indice = 1;
		}
//		(? ? ? ?)
//		setObjet()
// nome = 'kaleb',idade = 17
		for (; indice < camposNome.size(); indice++) {
			formato += camposNome.get(indice) + "=" + "'" + camposValor.get(indice) + "'" + " ,";
		}

		formato = formato.substring(0, formato.length() - 1) + "";
		System.out.println(formato);
		return formato;
	}

	public <T extends Tabela<?>> Mensagem remover(T tabela) {
		String sqlDelet = "delete from " + tabela.getNomeTabela() + " where " + tabela.getNomePk() + " = "
				+ tabela.getPk();
		System.out.println(sqlDelet);
		try {
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(sqlDelet);
			stmt.execute();

			return mensagem.getMensagemSucesso("112");

		} catch (SQLException e) {

			return mensagem.getMensagemErro("101", e.getMessage());
		}
	}

	public <T extends Tabela<?>> String prepararCamposNome(T tabela) {
		List<String> camposNome = tabela.getCamposNome();

		if (tabela.isPkSerial())
			camposNome.remove(0);

		String formato = "(";

		for (String campo : camposNome) {

			formato += campo + ",";
		}
		formato = formato.substring(0, formato.length() - 1) + ")";
		System.out.println(formato);
		return formato;
	}

	public <T extends Tabela<?>> String prepararCamposValor(T tabela) {
		List<Object> camposNome = tabela.getCamposValor();

		String formato = "(";

		for (Object campo : camposNome)
			formato += "'" + campo + "'" + ",";

		formato = formato.substring(0, formato.length() - 1) + ")";
		System.out.println(formato);
		return formato;
	}

	public <T extends Tabela<?>> void inserir(T tabela) {
		String sql = "insert into " + tabela.getNomeTabela() + " values"
				+ prepararCamposValor(tabela);

		System.out.println(sql);
		try {
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(sql);

			// executa
			stmt.execute();
			System.out.println("Salvo Com Sucesso");

		} catch (SQLException e) {
			System.out.println("Deu Ruim");
			System.out.println(e.getMessage());

		}

	}

}
