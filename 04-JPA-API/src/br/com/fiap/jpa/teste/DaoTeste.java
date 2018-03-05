package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.SalaDAO;
import br.com.fiap.jpa.dao.impl.SalaDAOImpl;
import br.com.fiap.jpa.entity.Sala;
import br.com.fiap.jpa.entity.StatusSala;
import br.com.fiap.jpa.exception.CommitException;

public class DaoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		SalaDAO dao = new SalaDAOImpl(em);
		
		//Cadastrar
		Sala sala = new Sala(100, 6, "602", 
				StatusSala.DISPONIVEL, 
				Calendar.getInstance(), null);
		try {
			dao.cadastrar(sala);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Erro!");
		}
		
		//Buscar
		Sala salaBusca = dao.consultar(sala.getCodigo());
		System.out.println(salaBusca.getNome());
		
		//Atualizar 
		salaBusca.setNome("Maker Lab");
		try {
			dao.atualizar(salaBusca);
			dao.commit();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.excluir(salaBusca.getCodigo());
			dao.commit();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
	
}




