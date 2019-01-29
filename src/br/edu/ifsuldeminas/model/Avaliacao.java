package br.edu.ifsuldeminas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double torax;
	private Double cintura;
	private Double abdome;
	private Double quadril;
	private Double antebracos;
	private Double bracos;
	private Double coxas;
	private Double panturrilhas;
	private Double subscapular;
	private Double tricipital;
	private Double peitoral;
	private Double axilar_media;
	private Double supra_iliaca;
	private Double abdominal;
	private Double coxa;
	
	@ManyToOne
	private Aluno aluno = new Aluno();
	
	@ManyToOne
	private Professor professor = new Professor();
	
	@Temporal(TemporalType.DATE)
	private Calendar data_avaliacao = Calendar.getInstance();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTorax() {
		return torax;
	}

	public void setTorax(Double torax) {
		this.torax = torax;
	}

	public Double getCintura() {
		return cintura;
	}

	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	public Double getAbdome() {
		return abdome;
	}

	public void setAbdome(Double abdome) {
		this.abdome = abdome;
	}

	public Double getQuadril() {
		return quadril;
	}

	public void setQuadril(Double quadril) {
		this.quadril = quadril;
	}

	public Double getAntebracos() {
		return antebracos;
	}

	public void setAntebracos(Double antebracos) {
		this.antebracos = antebracos;
	}

	public Double getBracos() {
		return bracos;
	}

	public void setBracos(Double bracos) {
		this.bracos = bracos;
	}

	public Double getCoxas() {
		return coxas;
	}

	public void setCoxas(Double coxas) {
		this.coxas = coxas;
	}

	public Double getPanturrilhas() {
		return panturrilhas;
	}

	public void setPanturrilhas(Double panturrilhas) {
		this.panturrilhas = panturrilhas;
	}

	public Double getSubscapular() {
		return subscapular;
	}

	public void setSubscapular(Double subscapular) {
		this.subscapular = subscapular;
	}

	public Double getTricipital() {
		return tricipital;
	}

	public void setTricipital(Double tricipital) {
		this.tricipital = tricipital;
	}

	public Double getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Double peitoral) {
		this.peitoral = peitoral;
	}

	public Double getAxilar_media() {
		return axilar_media;
	}

	public void setAxilar_media(Double axilar_media) {
		this.axilar_media = axilar_media;
	}

	public Double getSupra_iliaca() {
		return supra_iliaca;
	}

	public void setSupra_iliaca(Double supra_iliaca) {
		this.supra_iliaca = supra_iliaca;
	}

	public Double getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(Double abdominal) {
		this.abdominal = abdominal;
	}

	public Double getCoxa() {
		return coxa;
	}

	public void setCoxa(Double coxa) {
		this.coxa = coxa;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Calendar getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Calendar data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
}