package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name="nr_crm")
	private long crm;
	
	@Column(name="nm_medico",nullable=false,length=100)
	private String nome;
	
	@Column(name="vl_salario",table="T_MEDICO_FINANCEIRO")
	private double salario;
	
	@Column(name="nr_conta",table="T_MEDICO_FINANCEIRO")
	private int conta;
	
	@Column(name="dt_pagamento",table="T_MEDICO_FINANCEIRO")
	private Calendar dataPagamento;
	
	public Medico(long crm, String nome, double salario, int conta, Calendar dataPagamento) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
		this.conta = conta;
		this.dataPagamento = dataPagamento;
	}

	public Medico(long crm, String nome, double salario) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
	}

	public Medico() {
		super();
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
