package utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Professor;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// Obt�m contexto da aplica��o
		FacesContext context = event.getFacesContext();
		// Obt�m o nome da p�gina que est� sendo chamada
		String nomePagina = context.getViewRoot().getViewId();

		// System.out.println(nomePagina);

		// se for a p�gina de login, o usu�rio pode acessar
		// if ("/login.xhtml".equals(nomePagina)) {
		// return;
		// }

		// Obt�m usu�rio da sess�o

		Aluno aluno = (Aluno) context.getExternalContext().getSessionMap().get("usuarioLogadoaluno");
		Professor professor = (Professor) context.getExternalContext().getSessionMap().get("usuarioLogadoprofessor");

		// se h� usu�rio logado, ele pode acessar as p�ginas
		if (professor == null || aluno ==null) {
			// // se for a index, o usu�rio pode acessar

			if (nomePagina.equals("/atividades/index.xhtml") || nomePagina.equals("/cadastro/aluno.xhtml")
					|| nomePagina.equals("/cadastro/atividade.xhtml") || nomePagina.equals("/PerfilVagas.xhtml")
					|| nomePagina.equals("/atividades.xhtml")) {
				NavigationHandler handler = context.getApplication().getNavigationHandler();
				handler.handleNavigation(context, null, "/login?faces-redirect=true");
				context.renderResponse();

				return;
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW; // o autorizador ser� executado na fase
										// restore_view
	}
}