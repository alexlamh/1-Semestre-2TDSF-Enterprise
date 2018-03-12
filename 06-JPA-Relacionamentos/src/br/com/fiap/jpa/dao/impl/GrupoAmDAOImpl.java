package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.GrupoAm;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.GrupoAmDAO;

public class GrupoAmDAOImpl 
			extends GenericDAOImpl<GrupoAm, Integer>
								implements GrupoAmDAO{

	public GrupoAmDAOImpl(EntityManager em) {
		super(em);
	}
	

}