package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

public class ConsultaPK implements Serializable {

	//Atributos que formam a chave composta
	private Calendar data;
	
	private long medico;
	
	private int paciente;
	
	public ConsultaPK() {
		super();
	}

	public ConsultaPK(Calendar data, long medico, int paciente) {
		super();
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public long getMedico() {
		return medico;
	}

	public void setMedico(long medico) {
		this.medico = medico;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (int) (medico ^ (medico >>> 32));
		result = prime * result + paciente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (medico != other.medico)
			return false;
		if (paciente != other.paciente)
			return false;
		return true;
	}
	
	
}
