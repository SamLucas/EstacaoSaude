package br.edu.ifsuldeminas.controller;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.AlunoEspecialidade;
import br.edu.ifsuldeminas.model.EspecialidadesMedicas;

@ManagedBean
@ViewScoped
public class AlunoEspecialidadeController {

	private AlunoEspecialidade ALESP = new AlunoEspecialidade();
	private Aluno aluu = new Aluno();

	private Integer id_aluno;
	private Integer id_especialidade;

	private List<AlunoEspecialidade> listalunespc = new LinkedList<AlunoEspecialidade>();

	// FUnntions.............
	public void gravar() {

		Dao<AlunoEspecialidade> dao = new Dao<AlunoEspecialidade>(AlunoEspecialidade.class);
		Aluno aln = new Dao<Aluno>(Aluno.class).listaPorId(id_aluno);
		EspecialidadesMedicas ESP = new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class)
				.listaPorId(id_especialidade);

		ALESP.setAln(aln);
		ALESP.setESPM(ESP);

		if (this.ALESP.getId() == null)
			dao.adiciona(ALESP);
		else
			dao.atualiza(this.ALESP);

		ALESP = new AlunoEspecialidade();
	}

	public List<Aluno> getTodosAluno() {
		return new Dao<Aluno>(Aluno.class).listaTodos();
	}

	public void getTodosAlunoPorEspecialidade() {
		listalunespc = new Dao<AlunoEspecialidade>(AlunoEspecialidade.class).listaTodos();
		for (AlunoEspecialidade a : listalunespc) {
			if (a.getAln().getId() != aluu.getId()) {
				listalunespc.remove(a);
			}
		}
	}

	public List<AlunoEspecialidade> getTodosAlunoEspecialidade() {
		return new Dao<AlunoEspecialidade>(AlunoEspecialidade.class).listaTodos();
	}

	public List<EspecialidadesMedicas> getTodosEspecialidade() {
		return new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class).listaTodos();
	}

	public void remover(AlunoEspecialidade aluno) {
		new Dao<AlunoEspecialidade>(AlunoEspecialidade.class).remove(aluno.getId());
	}

	public void carregar(AlunoEspecialidade aluno) {
		this.ALESP = aluno;
		id_aluno = ALESP.getAln().getId();
		id_especialidade = ALESP.getESPM().getId();
	}

	// Gets and Seterssss......................................
	public AlunoEspecialidade getALESP() {
		return ALESP;
	}

	public void setALESP(AlunoEspecialidade aLESP) {
		ALESP = aLESP;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public Integer getId_especialidade() {
		return id_especialidade;
	}

	public void setId_especialidade(Integer id_especialidade) {
		this.id_especialidade = id_especialidade;
	}

	public List<AlunoEspecialidade> getListalunespc() {
		return listalunespc;
	}

	public void setListalunespc(List<AlunoEspecialidade> listalunespc) {
		this.listalunespc = listalunespc;
	}
}