package com.camilo.spring.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camilo.spring.model.Banner;
import com.camilo.spring.services.IBannersService;
import com.camilo.spring.util.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio --Inyeccion de dependencia
	@Autowired
	private IBannersService serviceBanner;
		
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		
		model.addAttribute("banners", serviceBanner.buscarTodos());
		
		return "banners/listBanners";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {

		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, RedirectAttributes atributo,
			@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
	
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
		}
		
		if(!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			banner.setArchivo(nombreImagen);
		}
		
		serviceBanner.insertar(banner);
		atributo.addFlashAttribute("mensaje", "Registro guardado");
		
		return "redirect:/banners/index";
		
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
}
