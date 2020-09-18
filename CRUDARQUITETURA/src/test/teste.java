package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controle.CrudControle;
import modelo.Jogos;
import modelo.Select;

public class teste {

	public static void main(String[] args) {
		ArrayList<String> genero = new ArrayList<>();
		ArrayList<String> plataforma = new ArrayList<>();
		genero.add("plataforma");
		genero.add("aventura");
		plataforma.add("super nintendo");
		plataforma.add("game boy advance");
		Select linha = new Select(1, "super mario world", "jogo excelente",new Date(1994-12-01),0, new Date(1993-12-01),new Date(2020-12-01), genero, plataforma);
		CrudControle controle = new CrudControle();
		controle.criar(linha);
	}

}
