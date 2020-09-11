package test;

import java.util.ArrayList;

import model.DAOGeneric;

public class teste {

	public static void main(String[] args) {
		Jogos jogos=new Jogos();
		DAOGeneric dao=new DAOGeneric();
		ArrayList<Jogos> lista = dao.listar(jogos);
		for (Jogos jogos2 : lista) {
			System.out.println(jogos2.getNomePk()+"\n"+jogos2.getNome());
		}
		System.out.println(dao.remover(lista.get(0)));
	}

}
