package com.camilo.spring.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camilo.spring.model.Banner;
import com.camilo.spring.model.Pelicula;
import com.camilo.spring.services.IBannersService;
import com.camilo.spring.services.IPeliculasService;
import com.camilo.spring.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanner;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	
	

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome(Model model) {		
		
		return "home";
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDay(4);
		System.out.println(listaFechas);
		
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();		
		List<Banner> banners = serviceBanner.buscarTodos();
		
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("banners", banners);
		
		
		return "home";
	}
	
	
	@RequestMapping(value="/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
		
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		
		System.out.println("IdPelicula" + idPelicula);
		System.out.println("Buscando horarios para la pelicula: " + fecha);		
		
		model.addAttribute("pelicula", pelicula);
		
		
		// TODO --buscar en la base de datos los horarios
		
		return "detalle";
	}
	
	
	/*
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		System.out.println("IdPelicula" + idPelicula);
		System.out.println("Buscando horarios para la pelicula: " + fecha);		
		
		// TODO --buscar en la base de datos los horarios
		
		return "detalle";
	}
	*/
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha) {
		
		List<String> listaFechas = Utileria.getNextDay(4);	
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();		
		
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		
		return "home";
	}
	
	
	
	
	
}
