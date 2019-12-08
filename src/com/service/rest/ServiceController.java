package com.service.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pojos.Persona;
import com.pruebaJava.Database;

@RestController
public class ServiceController {
	
	Database db = new Database();
	
	// Recibir la información y almacenarla en la base de datos
	@RequestMapping(value = "/service/register", method = RequestMethod.POST)
	public String handlePersona(@ModelAttribute("persona") Persona personaForm,
			Model mod, RedirectAttributes ra) {
		
		String nombre = personaForm.getNombre();
		String apellido = personaForm.getApellido();
		
		String registro = db.register(nombre, apellido);
		
		ra.addAttribute("resultado",registro);
		
		return "redirect:/";
	}
}
