package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Sala;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;

public interface SalaDAO {

	void cadastrar(Sala sala);
	void excluir(int codigo) throws EntityNotFoundException;
	void atualizar(Sala sala);
	Sala consultar(int codigo);
	
	void commit() throws CommitException;
	
}






