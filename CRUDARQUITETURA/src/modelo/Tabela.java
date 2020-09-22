package modelo;

import java.util.List;


public abstract class Tabela<TipoPK> {
	private TipoPK pk;
	
	
	public TipoPK getPk() {
		return pk;
	}
	public void setPk(Object pk) {
		this.pk = (TipoPK) pk;
	}
	
	public abstract String getNomeTabela();
	public abstract void setCamposTabela(List<Object> list); 
	public abstract Tabela getNovoObjeto(); 
	public abstract String getNomePk(); 
	public abstract List<Object> getCamposValor(); 
	public abstract List<String> getCamposNome();
	public abstract String getCamposNomeStr();
	public abstract Boolean isPkSerial();
}