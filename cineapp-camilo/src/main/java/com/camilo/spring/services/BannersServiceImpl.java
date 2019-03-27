package com.camilo.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.camilo.spring.model.Banner;;;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		// Ejercicio: Crear una nueva lista enlazada	
		
		try {
			lista = new LinkedList<>();
			
			Banner banner1 = new Banner();
			banner1.setId(1);
			banner1.setTitulo("slide1");
			banner1.setFecha(formatter.parse("20-05-2019"));
			banner1.setArchivo("slide1.jpg");
			banner1.setEstatus("Inactivo");
			
			Banner banner2 = new Banner();
			banner2.setId(2);
			banner2.setTitulo("slide2");
			banner2.setFecha(formatter.parse("20-05-2019"));
			banner2.setArchivo("slide2.jpg");
			
			Banner banner3 = new Banner();
			banner3.setId(3);
			banner3.setTitulo("slide3");
			banner3.setFecha(formatter.parse("20-05-2019"));
			banner3.setArchivo("slide3.jpg");
			
			Banner banner4 = new Banner();
			banner4.setId(4);
			banner4.setTitulo("slide4");
			banner4.setFecha(formatter.parse("20-05-2019"));
			banner4.setArchivo("slide4.jpg");
			
			Banner banner5 = new Banner();
			banner5.setId(5);
			banner5.setTitulo("slide5");
			banner5.setFecha(formatter.parse("20-05-2019"));
			banner5.setArchivo("slide5.jpg");
			
			Banner banner6 = new Banner();
			banner6.setId(6);
			banner6.setTitulo("slide6");
			banner6.setFecha(formatter.parse("20-05-2019"));
			banner6.setArchivo("slide6.jpg");
			
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);
			lista.add(banner5);
			lista.add(banner6);
			
		} catch (ParseException e) {
			System.out.println("Error" + e.getMessage());
		}
		
		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		lista.add(banner);
		
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {
		
		return lista;
		
		
	}

}
