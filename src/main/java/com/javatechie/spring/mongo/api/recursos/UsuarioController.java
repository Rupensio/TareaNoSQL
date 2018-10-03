package com.javatechie.spring.mongo.api.recursos;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.modelo.Usuario;
import com.javatechie.spring.mongo.api.repositorio.UsuarioRepositorio;



@RestController
public class UsuarioController {

		
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@RequestMapping(value = "/addUsuario", method = RequestMethod.POST)
	public String saveUsuario(@RequestBody Usuario usuario) {
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
			      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		String email = usuario.getEmail();
		Pattern pattern = Pattern.compile(emailPattern);
		if (email != null) {
			   Matcher matcher = pattern.matcher(email);
			   if (matcher.matches()) {
				   repositorio.save(usuario);
			   	   return "Se añadió usuario con email : " + usuario.getEmail();
			   }
		}
		return "El formato del mail ingresado no es válido. Verifique por favor";
	}
	
		
	@GetMapping("/findAllUsuarios")
	public List<Usuario> getUsuarios(){
		return repositorio.findAll();
		
	}
}
