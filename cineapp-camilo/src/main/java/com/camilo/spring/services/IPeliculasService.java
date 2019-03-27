package com.camilo.spring.services;

import java.util.List;

import com.camilo.spring.model.Pelicula;

public interface IPeliculasService {

	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGeneros();
}
