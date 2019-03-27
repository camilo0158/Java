package com.camilo.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camilo.spring.model.Pelicula;
import com.camilo.spring.services.IPeliculasService;
import com.camilo.spring.util.Utileria;


@Controller
@RequestMapping("/peliculas")
public class PeliculasCotroller {
	
	@Autowired
	private IPeliculasService servicePelicula;
	

	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		
		model.addAttribute("generos", servicePelicula.buscarGeneros());
		
		return "peliculas/formPelicula";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
		
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes atributo,
			@RequestParam("archivoImagen" )MultipartFile multiPart, HttpServletRequest request)
	{
		
		
		
		if(result.hasErrors()) {
			System.out.println("Existieron errores" + pelicula.getFechaEstreno());
			
			return "peliculas/formPelicula";
		}
		
		if(!multiPart.isEmpty()) {
			System.out.println("LLego archivo" + multiPart.getOriginalFilename());
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}
		
		/*
		for(ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		*/		
	
		servicePelicula.insertar(pelicula);
		atributo.addFlashAttribute("mensaje", "Registro guardado");
		
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
