package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Sala;
import br.com.fiap.jpa.entity.StatusSala;

public class CadastroTeste {

	public static void main(String[] args) {
		//Fabrica
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		//EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		Sala sala = new Sala(40, 7, "703",  
				StatusSala.INDISPONIVEL, 
				new GregorianCalendar(2017, Calendar.MARCH, 2), 
				null);
		
		//Cadastrar a sala
		em.persist(sala);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}







