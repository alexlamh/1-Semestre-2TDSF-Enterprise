package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.SalaDAO;
import br.com.fiap.jpa.entity.Sala;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;

public class SalaDAOImpl implements SalaDAO {

	private EntityManager em;
	
	public SalaDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Sala sala) {
		em.persist(sala);
	}

	@Override
	public void excluir(int codigo) throws EntityNotFoundException {
		Sala sala = consultar(codigo);
		if (sala == null)
			throw new EntityNotFoundException("Entidade n�o encontrada");
		em.remove(sala);
	}

	@Override
	public void atualizar(Sala sala) {
		em.merge(sala);
	}

	@Override
	public Sala consultar(int codigo) {
		Sala sala = em.find(Sala.class, codigo);
		return sala;
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}
	}
	
}



