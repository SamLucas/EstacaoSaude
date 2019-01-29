package br.edu.ifsuldeminas.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dao.UsuarioDao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Professor;

@ManagedBean
@ViewScoped
public class LoginController {
	
	private Aluno aluno = new Aluno();
	private Professor prof = new Professor();
	private Integer categoria;
	
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor getProf() {
		return prof;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void verificaLogado() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getExternalContext().getSessionMap().get("usuarioLogado") == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();

			facesContext.getExternalContext().redirect("login.xhtml");
		}
		else{
			FacesContext facesContext = FacesContext.getCurrentInstance();

			facesContext.getExternalContext().redirect("Perfil.xhtml");
		}
	}

	public Aluno getUsuAlun() {
		FacesContext context = FacesContext.getCurrentInstance();

		return (Aluno) context.getExternalContext().getSessionMap().get("usuarioLogado");
	}
	
	public Professor getUsuPro() {
		FacesContext context = FacesContext.getCurrentInstance();

		return (Professor) context.getExternalContext().getSessionMap().get("usuarioLogado");
	}

	public String logar() {
		System.out.println(categoria);
		if(categoria == 0) {
			aluno = new UsuarioDao().buscarPorUsuarioESenhaaluno(email,senha);
			FacesContext context = FacesContext.getCurrentInstance();
			if (this.aluno != null) {
				context.getExternalContext().getSessionMap().put("usuarioLogadoaluno", aluno);
				System.out.println("Logado!!!");
				return "minhas_atividades?faces-redirect=true";
				
			} else {
				context.getExternalContext().getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage("Usuario e/ou senha incorretos"));
				return "minhas_atividades?faces-redirect=true";
			}
			
		} else {
			prof = new UsuarioDao().buscarPorUsuarioESenhaprofessor(email,senha);
			FacesContext context = FacesContext.getCurrentInstance();
			if (prof != null) {
				context.getExternalContext().getSessionMap().put("usuarioLogadoprofessor", prof);
				System.out.println("Logado!!!");
				return "Index.xhtml?faces-redirect=true";
				
			} else {
				context.getExternalContext().getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage("Usuario e/ou senha incorretos"));
				return "minhas_atividades?faces-redirect=true";
				
			}
		}		
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(context.getExternalContext().getSessionMap().get("usuarioLogadoprofessor") != null) {
			context.getExternalContext().getSessionMap().clear();
			prof = null;
		}
		if(context.getExternalContext().getSessionMap().get("usuarioLogadoaluno") != null) {
			context.getExternalContext().getSessionMap().clear();
			aluno = null;
		}
		return "login?faces-redirect=true";
	}

//	public void preenche() {
//		FacesContext context = FacesContext.getCurrentInstance();
//
//		this.usuario = (Pessoa) context.getExternalContext().getSessionMap().get("usuarioLogado");
//		System.out.println(this.usuario.getNome());
//		
//		setA(this.usuario.getData_contrato());  
//		
//	}
//	
//	public void preenche2() {
//		
//		FacesContext context = FacesContext.getCurrentInstance();
//
//		this.pj = (PessoaJuridica) context.getExternalContext().getSessionMap().get("usuarioLogado");
//		System.out.println(this.pj.getRazaoSocial());
//	}

}