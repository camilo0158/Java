package com.camilo.spring.controller;

import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.camilo.spring.model.Contacto;
import com.camilo.spring.services.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePeliculas;

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto, Model model) {
		model.addAttribute("generos", servicePeliculas.buscarGeneros());
		model.addAttribute("tipos", tipoNotificaciones());
		return "formContacto";
	}
	
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto) {
		
		// Este objeto ya se pondria ingresar en la base de datos
		System.out.println(contacto);		
		return "redirect:/contacto";
		
	}
	
	private List<String> tipoNotificaciones(){
		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promiciones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		return tipos;
	}

}
