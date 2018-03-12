package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ProjetoAmDAO;
import br.com.fiap.jpa.entity.ProjetoAm;

public class ProjetoAmDAOImpl 
			extends GenericDAOImpl<ProjetoAm,Integer>
								implements ProjetoAmDAO{

	public ProjetoAmDAOImpl(EntityManager em) {
		super(em);
	}

}
