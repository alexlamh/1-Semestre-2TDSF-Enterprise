package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ChurrosDAO;
import br.com.fiap.jpa.entity.Churros;

public class ChurrosDAOImpl 
			extends GenericDAOImpl<Churros, Integer> 
										implements ChurrosDAO {

	public ChurrosDAOImpl(EntityManager em) {
		super(em);
	}

}
