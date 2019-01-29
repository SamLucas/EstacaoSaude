package br.edu.ifsuldeminas.controller;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.dao.RegistroDao;
import br.edu.ifsuldeminas.model.Atividade;
import br.edu.ifsuldeminas.model.Frequencia;
import br.edu.ifsuldeminas.model.RegistrosAtividades;

@ManagedBean
@ViewScoped
public class FrequenciaController {
	
	private Frequencia freq = new Frequencia();
	private Integer id_registro;
	
	private List<RegistrosAtividades> REg = new LinkedList<RegistrosAtividades>();	
	private Calendar data = Calendar.getInstance();
	
	// Functionssss
	public void gravar(){
		
		Dao<Frequencia> dao = new Dao<Frequencia>(Frequencia.class);
		RegistrosAtividades req = new Dao<RegistrosAtividades>(RegistrosAtividades.class).listaPorId(id_registro);
		
		freq.setReg(req);
		
		if(this.freq.getId() == null) dao.adiciona(freq);
		else dao.atualiza(this.freq);
		freq = new Frequencia();
	}
	
	public void remover(RegistrosAtividades reg){
		new Dao<RegistrosAtividades>(RegistrosAtividades.class).remove(reg.getId());
	}
	
	public void buscar(){
		REg = new RegistroDao().listaTodosPorData(data);
	}
	
	public List<Atividade> getTodosAtividade(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}
	
	public void presensa(RegistrosAtividades aa) {
		String Strii = "presensa";
		freq.setReg(aa);
		freq.setPresensa(Strii);
		new Dao<Frequencia>(Frequencia.class).adiciona(freq);
	}
	
	public void falta(RegistrosAtividades aa) {
		String Strii = "falta";
		freq.setReg(aa);
		freq.setPresensa(Strii);
		new Dao<Frequencia>(Frequencia.class).adiciona(freq); 
	}
	

	// get and seters............
	public Frequencia getFreq() {
		return freq;
	}

	public void setFreq(Frequencia freq) {
		this.freq = freq;
	}

	public Integer getId_registro() {
		return id_registro;
	}

	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}

	public List<RegistrosAtividades> getREg() {
		return REg;
	}

	public void setREg(List<RegistrosAtividades> rEg) {
		REg = rEg;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
}