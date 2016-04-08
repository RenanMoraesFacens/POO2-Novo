package sistema.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean {

	private Professor professor = new Professor();
	private List<Professor> professores;
	private ProfessorService service = new ProfessorService();

	
	//Edição de um professor na tabela
	public void onRowEdit(RowEditEvent event) {

		Professor p = ((Professor) event.getObject());
		service.alterar(p);
	}
	public void salvar() {
		service.salvar(professor);

		if (professores != null)
			professores.add(professor);

		professor = new Professor();

	}

	public Professor getAluno() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	//Retorna a lista de professores para a tabela
	public List<Professor> getProfessores() {
		if (professores == null)
			professores = service.getProfessores();

		return professores;
	}

	public void remover(Professor professor) {
		service.remover(professor);
		professores.remove(professor);

	}

}
