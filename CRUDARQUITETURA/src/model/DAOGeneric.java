package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mensagem.Mensagem;
import mensagem.PersistenciaMensagem;

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
		String sqlSelect = "select * from " + tabela.getNomeTabela();
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

	public <T extends Tabela<?>> Mensagem remover(T tabela) {
		String sqlDelet = "delete from "
				+ tabela.getNomeTabela()
				+ " where " + tabela.getNomePk() + " = " + tabela.getPk();
		System.out.println(sqlDelet);
		try {
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(sqlDelet);
			stmt.execute();
			
			return mensagem.getMensagemSucesso("112");
	
		} catch (SQLException e) {
			
			return mensagem.getMensagemErro("101",e.getMessage());
		}
	}

}
