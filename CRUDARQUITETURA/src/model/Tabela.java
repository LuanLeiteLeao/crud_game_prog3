package model;

import java.util.List;


public abstract class Tabela {

	protected  abstract String getNomeTabela();
	public abstract void setCamposTabela(List<Object> list); 
	public abstract Tabela getNovoObjeto(); 
}