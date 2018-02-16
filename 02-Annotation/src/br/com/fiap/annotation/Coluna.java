package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Mantem a anota��o at� a execu��o
@Retention(RetentionPolicy.RUNTIME)
//Define que a anota��o � para atributos
@Target(ElementType.FIELD) 
public @interface Coluna {

	String nome();
	
}
