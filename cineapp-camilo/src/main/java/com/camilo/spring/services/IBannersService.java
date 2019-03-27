package com.camilo.spring.services;

import java.util.List;
import com.camilo.spring.model.Banner;;;

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
