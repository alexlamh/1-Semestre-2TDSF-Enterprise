package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CHURROS")
@SequenceGenerator(name="churros",sequenceName="SQ_T_CHURROS",allocationSize=1)
public class Churros {

	@Id
	@Column(name="cd_churros")
	@GeneratedValue(generator="churros",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_sabor",nullable=false,length=20)
	private String sabor;
	
	@Column(name="vl_churros",nullable=false)
	private float preco;
	
	public Churros() {
		super();
	}

	public Churros(String sabor, float preco) {
		super();
		this.sabor = sabor;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
