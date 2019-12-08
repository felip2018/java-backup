package com.pruebaJava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pojos.Persona;

@Controller
public class IndexController {
	
	Database db = new Database();
	
	@RequestMapping("/")
	public String showIndex(Model mod, @ModelAttribute("resultado") String resultado) {
		
		Persona persona = new Persona();
		
		mod.addAttribute("persona",persona);
		mod.addAttribute("resultado",resultado);
		
		return "index";
	}
	
	// Recibir la información y almacenarla en la base de datos
	@RequestMapping(value = "/persona/registrar", method = RequestMethod.POST)
	public String handlePersona(@ModelAttribute("persona") Persona personaForm,
			Model mod, RedirectAttributes ra) {
		
		String nombre = personaForm.getNombre().toUpperCase();
		String apellido = personaForm.getApellido().toUpperCase();
		
		String registro = db.register(nombre, apellido);
		
		ra.addFlashAttribute("resultado",registro);
		
		return "redirect:/";
	}
	
	@RequestMapping("/consultas")
	public String showConsultas(Model mod) {
		
		Persona persona = new Persona();
		
		mod.addAttribute("persona",persona);
		mod.addAttribute("registros",db.verRegistros());
		
		return "consultas";
	}
	
	// Procesar registros seleccionados
	@RequestMapping(value = "/persona/procesar", method = RequestMethod.POST)
	public String handleProcesamiento(Model mod, @RequestParam("procesar") int[] identificadores) {
		
		//mod.addAttribute("procesar",procesar);
		db.procesarRegistros(identificadores);
		
		return "redirect:/consultas";
	}
	
}
