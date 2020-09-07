package model;

import java.util.List;


public abstract class Tabela<TipoPK> {
	private TipoPK pk;
	
	
	public TipoPK getPk() {
		return pk;
	}
	public void setPk(TipoPK pk) {
		this.pk = pk;
	}
	
	
	
	public  abstract String getNomeTabela();
	protected abstract void setCamposTabela(List<Object> list); 
	public abstract Tabela getNovoObjeto(); 
	public abstract String getNomePk(); 
	
	
	
}