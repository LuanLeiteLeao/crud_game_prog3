package model;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public abstract class Tabela {

	public abstract Tabela getNovoObjeto();

	public String convertLowerCaseWithUnderscores(String nome) {
		String nomeConvertido = "";
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
				if (i == 0) {
					nomeConvertido += c;

				} else {
					nomeConvertido += "_" + c;

				}

			} else {
				nomeConvertido += c;
			}

		}

		return nomeConvertido;

	}

	private String getNomeClassFilha() {
		String nome;
		Class<?> enclosingClass = getClass().getEnclosingClass();
		if (enclosingClass != null) {
			nome = enclosingClass.getName();
		} else {
			nome = getClass().getSimpleName();

		}
		return nome;
	}

	protected String getNomeTabela() {

		return this.convertLowerCaseWithUnderscores(this.getNomeClassFilha());
	}




	protected abstract  void setCamposValor(List<Object> list); 

}
