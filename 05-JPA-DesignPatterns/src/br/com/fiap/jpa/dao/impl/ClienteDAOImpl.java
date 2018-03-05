package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ClienteDAO;
import br.com.fiap.jpa.entity.Cliente;

public class ClienteDAOImpl 
				extends GenericDAOImpl<Cliente, String>
							implements ClienteDAO{

	public ClienteDAOImpl(EntityManager em) {
		super(em);
	}

}