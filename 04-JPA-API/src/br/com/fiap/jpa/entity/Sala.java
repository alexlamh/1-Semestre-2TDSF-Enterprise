package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_SALA")
@SequenceGenerator(name="sala",sequenceName="SQ_T_SALA",allocationSize=1)
public class Sala implements Serializable {

	@Id
	@Column(name="cd_sala")
	@GeneratedValue(generator="sala",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="vl_capacidade",nullable=false)
	private int capacidade;
	
	@Column(name="nr_andar",nullable=false)
	private int andar;
	
	@Column(name="nm_sala",length=50)
	private String nome;
	
	@Column(name="st_sala",nullable=false)
	private StatusSala status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inauguracao")
	private Calendar dataInauguracao;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;

	public Sala() {
		super();
	}

	public Sala(int capacidade, int andar, String nome, StatusSala status, Calendar dataInauguracao, byte[] foto) {
		super();
		this.capacidade = capacidade;
		this.andar = andar;
		this.nome = nome;
		this.status = status;
		this.dataInauguracao = dataInauguracao;
		this.foto = foto;
	}
	
	@PrePersist
	public void antesCadastrar() {
		System.out.println("Sala será cadastrada");
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusSala getStatus() {
		return status;
	}

	public void setStatus(StatusSala status) {
		this.status = status;
	}

	public Calendar getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(Calendar dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}