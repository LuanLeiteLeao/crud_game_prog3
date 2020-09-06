package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOGeneric extends DAOConexao {
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

	public <T extends Tabela> ArrayList<T> listar(T tablea) {
		String sqlSelect = "select * from " + tablea.getNomeTabela();
		ArrayList<T> lista = new ArrayList<>();
		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) this.con.prepareStatement(sqlSelect);

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet

			while (rs.next()) {
				T auxTab = (T) tablea.getNovoObjeto();
				auxTab.setCamposTabela(this.getCamposValores(rs));
				lista.add(auxTab);
			}
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

}
