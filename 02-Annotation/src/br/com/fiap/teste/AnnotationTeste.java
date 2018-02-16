package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Produto;

public class AnnotationTeste {

	public static void main(String[] args) {
		Produto produto = new Produto(1,"Churros");
		
		//API de Refletion para recuperar a estrutura da classe
		String nome = produto.getClass().getName();
		System.out.println(nome);
		
		//Recuperar os métodos
		Method[] metodos =
					produto.getClass().getDeclaredMethods();
		for (Method method : metodos) {
			System.out.println(method.getName());
		}
		
		//Recuperar os atributos
		Field[] atributos = 
				produto.getClass().getDeclaredFields();
		for (Field field: atributos) {
			System.out.println(field.getName());
			//Recuperar a anotação
			Coluna anotacao = field.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
		}
		
	}
	
}




