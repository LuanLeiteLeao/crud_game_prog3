package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import controle.Controle;
import controle.CrudControle;
import modelo.Games_has_generos;
import modelo.Games_has_plataformas;
import modelo.Generos;
import modelo.Jogos;
import modelo.Plataformas;

public class teste {

	public static void main(String[] args) {
		Controle controle = new Controle();
		ArrayList<Object> teste;
		Jogos linhaJ = new Jogos(null, null, null, null, null, null, null);
		Games_has_plataformas linhaGa = new Games_has_plataformas(null, null);
		Plataformas linhaGe = new Plataformas(null, null);
		teste=controle.executar("Compare",linhaJ,linhaGa,linhaGe);
		for (Object l:teste) {
			System.out.println(l);
		}
	}

}
