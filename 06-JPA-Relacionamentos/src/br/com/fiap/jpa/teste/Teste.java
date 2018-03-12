package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GrupoAmDAO;
import br.com.fiap.jpa.dao.ProjetoAmDAO;
import br.com.fiap.jpa.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.jpa.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.jpa.entity.GrupoAm;
import br.com.fiap.jpa.entity.ProjetoAm;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar o projeto e o grupo
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ProjetoAmDAO projetoDao = new ProjetoAmDAOImpl(em);
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		
		ProjetoAm projeto = new ProjetoAm("TSystem",
			Calendar.getInstance(), 
			new GregorianCalendar(2018, Calendar.OCTOBER, 12));
		
		GrupoAm grupo = new GrupoAm("Spring", 0, projeto);
		
		try {
			//projetoDao.cadastrar(projeto);
			grupoDao.cadastrar(grupo);
			grupoDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}