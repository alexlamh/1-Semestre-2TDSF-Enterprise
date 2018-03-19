package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROFESSOR")
@SequenceGenerator(name="professor",sequenceName="SQ_T_PROFESSOR",allocationSize=1)
public class Professor {

	@Id
	@Column(name="cd_professor")
	@GeneratedValue(generator="professor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_professor",nullable=false,length=50)
	private String nome;
	
	@Column(name="vl_salario")
	private double salario;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_PROFESSOR_PROJETO",
			joinColumns=@JoinColumn(name="cd_professor"),
			inverseJoinColumns=@JoinColumn(name="cd_projeto"))
	private List<ProjetoAm> projetos;
	
	public Professor() {
		super();
	}

	public Professor(String nome, double salario, List<ProjetoAm> projetos) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.projetos = projetos;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<ProjetoAm> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoAm> projetos) {
		this.projetos = projetos;
	}
	
}
