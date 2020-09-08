package model;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;


public abstract class Tabela<TipoPK> {
	private TipoPK pk;
	
	
	public TipoPK getPk() {
		return pk;
	}
	public void setPk(TipoPK pk) {
		this.pk = pk;
	}
	
	
	
	public abstract String getNomeTabela();
	public abstract void setCamposTabela(List<Object> list); 
	public abstract Tabela getNovoObjeto(); 
	public abstract String getNomePk(); 
	public abstract List<Object> getCamposValor(); 
	public abstract List<String> getCamposNome();
	public abstract Boolean isPkSerial();
	
	
}