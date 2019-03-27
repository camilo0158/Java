package com.camilo.spring.pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.camilo.spring.model.Noticia;

public class AppCreate {

	public static void main(String[] args) {

		Noticia noticia = new Noticia();
		noticia.setTitulo("Prueba");
		noticia.setDetalle("Prueba detalle");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		/*
		 * NoticiasRepository repository = context.getBean("noticiasRepository",
		 * NoticiasRepository.class); repository.save(noticia);
		 */
		context.close();

	}

}
