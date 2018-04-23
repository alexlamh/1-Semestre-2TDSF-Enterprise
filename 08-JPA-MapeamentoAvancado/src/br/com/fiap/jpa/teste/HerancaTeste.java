package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar uma pessoa, pessoa fisica e pessoa juridica
		Pessoa pessoa = new Pessoa("Thiago", "thiago@fiap.com.br");
		
		PessoaFisica pf = new PessoaFisica("João", 
				"joao@fiap.com.br", "123.65.566-55", 
				new GregorianCalendar(1980, Calendar.AUGUST, 20));
		
		PessoaJuridica pj = new PessoaJuridica("FIAP", 
				"fiap@fiap.com.br", "12.325.321/0001-52", 
				new GregorianCalendar(1994, Calendar.JANUARY, 14));
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		dao.cadastrar(pessoa);
		dao.cadastrar(pj);
		dao.cadastrar(pf);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}


