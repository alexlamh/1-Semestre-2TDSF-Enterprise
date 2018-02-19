package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso",sequenceName="SQ_T_CURSO",allocationSize=1)
public class Curso implements Serializable {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator="curso",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso",nullable=false,length=100)
	private String nome;
	
	@Column(name="nr_horas")
	private Integer horas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	@Column(name="vl_enade")
	private Float notaEnade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoCurso tipo;
	
	public Curso(String nome, Integer horas, Calendar dataLancamento, Float notaEnade, TipoCurso tipo) {
		super();
		this.nome = nome;
		this.horas = horas;
		this.dataLancamento = dataLancamento;
		this.notaEnade = notaEnade;
		this.tipo = tipo;
	}

	public Curso() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Float getNotaEnade() {
		return notaEnade;
	}

	public void setNotaEnade(Float notaEnade) {
		this.notaEnade = notaEnade;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	
}
