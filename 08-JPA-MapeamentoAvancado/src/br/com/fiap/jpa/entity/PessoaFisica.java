package br.com.fiap.jpa.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PESSOA_FISICA")

//@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	@Column(name="nr_cpf")
	private String cpf;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String email, String cpf, Calendar dataNascimento) {
		super(nome, email);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
