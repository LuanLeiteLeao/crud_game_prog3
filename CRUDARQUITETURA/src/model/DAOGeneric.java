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
	
/*
 * Listar todos campos da tabela
 * select * from <TabelaGenerica>	
 */
	public <T extends Tabela>  void listar(T tablea ){
	}	
	
}
