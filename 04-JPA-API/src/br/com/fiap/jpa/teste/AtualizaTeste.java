package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Sala;
import br.com.fiap.jpa.entity.StatusSala;

public class AtualizaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Atualizar uma sala no banco de dados
		Sala sala = new Sala(70, 7, "701", 
				StatusSala.DISPONIVEL, 
				new GregorianCalendar(2015, Calendar.JANUARY,1),
				null);
		
		sala.setCodigo(1);
		
		em.merge(sala);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}