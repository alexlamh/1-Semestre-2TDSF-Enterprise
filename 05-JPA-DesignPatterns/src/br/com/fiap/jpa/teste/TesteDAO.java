package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ClienteDAO;
import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.ClienteDAOImpl;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.TipoCliente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteDAO {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Cliente cliente = new Cliente("thiago@fiap.com",
				"Thiago", 100, TipoCliente.PF);
		//Cadastrar
		try {
			dao.cadastrar(cliente);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Buscar
		Cliente busca = dao.buscar("thiago@fiap.com");
		System.out.println(busca.getNome());

		//Atualizar
		busca.setNome("Thiago Yamamoto");
		try {
			dao.atualizar(busca);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Remover
		try {
			dao.remover("thiago@fiap.com");
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}
	
}
