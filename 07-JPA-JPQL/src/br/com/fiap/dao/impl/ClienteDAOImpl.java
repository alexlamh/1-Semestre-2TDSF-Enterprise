package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		//Criar a query (JPQL)
		TypedQuery<Cliente> query = 
				em.createQuery("from Cliente",Cliente.class);
		//Máximo de resultados da busca
		query.setMaxResults(2);
		//Executa a query
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = 
			em.createQuery("from Cliente c where c.nome like :churros",Cliente.class);
		query.setParameter("churros", "%"+nome+"%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :e",Cliente.class);
		query.setParameter("e", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r where r.numeroDias = :n",Cliente.class);
		query.setParameter("n", dias);
		return query.getResultList();
	}

	@Override
	public long contarTotal() {
		TypedQuery<Long> query = em.createQuery(
			"select count(c) from Cliente c",Long.class);
		return query.getSingleResult();
	}

}







