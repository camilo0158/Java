package com.camilo.spring.services;

import org.springframework.stereotype.Service;

import com.camilo.spring.model.Noticia;


@Service
public class NoticiasService implements INoticiasService{

	public NoticiasService() {
		
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
		
		
	}
	
}
