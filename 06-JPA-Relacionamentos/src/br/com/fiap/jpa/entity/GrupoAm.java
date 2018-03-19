package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_GRUPO_AM")
@SequenceGenerator(name="grupo",sequenceName="SQ_T_GRUPO_AM",allocationSize=1)
public class GrupoAm {

	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(generator="grupo",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo",nullable=false,length=50)
	private String nome;
	
	@Column(name="vl_nota")
	private float nota;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_cd_projeto",nullable=false)
	private ProjetoAm projeto;

	@OneToMany(mappedBy="grupo",cascade=CascadeType.PERSIST)
	private List<Aluno> alunos = new ArrayList<>();
	
	public void adicionarAlunos(Aluno aluno) {
		alunos.add(aluno);
		aluno.setGrupo(this);
	}
	
	public GrupoAm(String nome, float nota, ProjetoAm projeto) {
		super();
		this.nome = nome;
		this.nota = nota;
		this.projeto = projeto;
	}

	public GrupoAm() {
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

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public ProjetoAm getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAm projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}