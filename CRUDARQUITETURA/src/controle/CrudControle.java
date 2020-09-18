package controle;

import java.util.ArrayList;
import modelo.Games_has_generos;
import modelo.Games_has_plataformas;
import modelo.Generos;
import modelo.Jogos;
import modelo.Plataformas;
import modelo.Select;
import persistencia.DAOGeneric;

public class CrudControle {
	Jogos jogos = new Jogos();
	Generos generos = new Generos();
	Plataformas plataformas = new Plataformas();
	Games_has_generos games_has_generos = new Games_has_generos();
	Games_has_plataformas games_has_plataformas = new Games_has_plataformas();
	DAOGeneric dao = new DAOGeneric();

	public ArrayList<Select> select() {
		ArrayList<Jogos> games = dao.listar(jogos);
		ArrayList<Generos> genders = dao.listar(generos);
		ArrayList<Plataformas> plataforms = dao.listar(plataformas);
		ArrayList<Games_has_generos> games_has_g = dao.listar(games_has_generos);
		ArrayList<Games_has_plataformas> games_has_p = dao.listar(games_has_plataformas);
		ArrayList<Select> select = new ArrayList<>();
		ArrayList<String> ge = new ArrayList<>();
		ArrayList<String> pl = new ArrayList<>();

		for (int i = 0; i < games.size(); i++) {
			Select linha = new Select(games.get(i).getId(), games.get(i).getNome(), games.get(i).getDescricao(),
					games.get(i).getData_lancamento(), games.get(i).getIs_jogo_do_ano(), games.get(i).getCriacao(),
					games.get(i).getModificacao(), null, null);
			for (int j = 0; j < games_has_g.size(); j++) {
				for (int k = 0; k < genders.size(); k++) {
					if (games_has_g.get(j).getGames_id() == games.get(i).getId()
							&& games_has_g.get(j).getGeneros_id() == genders.get(k).getId()) {
						ge.add(genders.get(k).getNome());
					}
				}
			}

			for (int j = 0; j < games_has_p.size(); j++) {
				for (int k = 0; k < plataforms.size(); k++) {
					if (games_has_p.get(j).getGames_id() == games.get(i).getId()
							&& games_has_p.get(j).getPlataformas_id() == plataforms.get(k).getId()) {
						pl.add(plataforms.get(k).getNome());
					}
				}
			}
			linha.setGenero(ge);
			linha.setPlataforma(pl);
			select.add(linha);
		}
		return select;
	}

	public String remover(Select linha) {

		jogos.setPk(linha.getId());
		for (int i = 0; i < linha.getGenero().size(); i++) {
			games_has_generos.setPk(linha.getId());
			dao.remover(games_has_generos);
		}
		for (int i = 0; i < linha.getPlataforma().size(); i++) {
			games_has_plataformas.setPk(linha.getId());
			dao.remover(games_has_plataformas);
		}
		dao.remover(jogos);
		return null;
	}

	public String criar(Select linha) {
		ArrayList<Generos> genders = dao.listar(generos);
		ArrayList<Plataformas> plataforms = dao.listar(plataformas);
		jogos.setPk(linha.getId());
		jogos.setId(linha.getId());
		jogos.setNome(linha.getNome());
		jogos.setDescricao(linha.getDescricao());
		jogos.setIs_jogo_do_ano(linha.getIs_jogo_do_ano());
		jogos.setData_lancamento(linha.getData_lancamento());
		jogos.setCriacao(linha.getCriacao());
		jogos.setModificacao(linha.getModificacao());
		
		dao.inserir(jogos);
		
		for (int i = 0; i < genders.size(); i++) {
			for (int j = 0; j < linha.getGenero().size(); j++) {
				if (genders.get(i).getNome().equals(linha.getGenero().get(j))) {
					games_has_generos.setPk(linha.getId());
					games_has_generos.setGames_id(linha.getId());
					games_has_generos.setGeneros_id(genders.get(i).getId());
					dao.inserir(games_has_generos);
				}
			}
		}
		for (int i = 0; i < plataforms.size(); i++) {
			for (int j = 0; j < linha.getPlataforma().size(); j++) {
				if (plataforms.get(i).getNome().equals(linha.getPlataforma().get(j))) {
					games_has_plataformas.setPk(linha.getId());
					games_has_plataformas.setGames_id(linha.getId());
					games_has_plataformas.setPlataformas_id(plataforms.get(i).getId());
					dao.inserir(games_has_plataformas);
				}
			}

		}
		return null;
	}

	public String alterar(Select linha) {
		jogos.setPk(linha.getId());
		jogos.setId(linha.getId());
		jogos.setNome(linha.getNome());
		jogos.setDescricao(linha.getDescricao());
		jogos.setIs_jogo_do_ano(linha.getIs_jogo_do_ano());
		jogos.setData_lancamento(linha.getData_lancamento());
		jogos.setCriacao(linha.getCriacao());
		jogos.setModificacao(linha.getModificacao());
		dao.atualizar(jogos);
		return null;
	}
}
