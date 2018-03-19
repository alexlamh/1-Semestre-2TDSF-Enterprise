package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GrupoAmDAO;
import br.com.fiap.jpa.dao.ProfessorDAO;
import br.com.fiap.jpa.dao.ProjetoAmDAO;
import br.com.fiap.jpa.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.jpa.dao.impl.ProfessorDAOImpl;
import br.com.fiap.jpa.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.GrupoAm;
import br.com.fiap.jpa.entity.Professor;
import br.com.fiap.jpa.entity.ProjetoAm;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar o projeto e o grupo, alunos e professores
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ProjetoAm projeto = new ProjetoAm("SUS",
			Calendar.getInstance(), 
			new GregorianCalendar(2018, Calendar.OCTOBER, 12));
		
		GrupoAm grupo = new GrupoAm("Spring", 0, projeto);
		
		Aluno aluno1 = new Aluno("RM77888","Breno",null);
		Aluno aluno2 = new Aluno("RM77932","Pedro",null);
		Aluno aluno3 = new Aluno("RM77985","Adriel",null);
		
		grupo.adicionarAlunos(aluno1);
		grupo.adicionarAlunos(aluno2);
		grupo.adicionarAlunos(aluno3);
		
		List<ProjetoAm> projetos = new ArrayList<>();
		projetos.add(projeto);
		
		Professor prof1 = new Professor("Thiago",3000,projetos);
		Professor prof2 = new Professor("Humberto",20000,projetos);
		
		ProfessorDAO pDao = new ProfessorDAOImpl(em);
		
		projeto.setGrupo(grupo);
		
		try {
			pDao.cadastrar(prof1);
			pDao.cadastrar(prof2);
			pDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}