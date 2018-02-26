package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Sala;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma sala no banco de dados 
				//tabela, chave primária
		Sala sala = em.find(Sala.class, 1);
		
		System.out.println(sala.getNome());
		System.out.println(sala.getCapacidade());
		
		em.close();
		//fabrica.close();
		
	}
	
}