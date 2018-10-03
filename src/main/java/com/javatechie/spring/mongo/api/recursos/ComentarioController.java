package com.javatechie.spring.mongo.api.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.javatechie.spring.mongo.api.modelo.Comentario;
import com.javatechie.spring.mongo.api.repositorio.ComentarioRepositorio;
import com.javatechie.spring.mongo.api.repositorio.UsuarioRepositorio;


@RestController
public class ComentarioController {
	
	@Autowired
	private ComentarioRepositorio repositorio;
	@Autowired
	private UsuarioRepositorio repositorio1;
	
	@RequestMapping(value = "/addComentario", method = RequestMethod.POST)
	public String saveComentario(@RequestBody Comentario comentario) {
		if (repositorio1.existsById(comentario.getEmail())) {
			if(comentario.getComentario().length() <= 256){
				repositorio.save(comentario);
				if(comentario.getidComentarioAComentar()==null) {
					comentario.setidComentarioAComentar(comentario.getId());
					repositorio.save(comentario);
					return "Se añadió comentario del usuario : " + comentario.getEmail() + "  identificado con ID : " + comentario.getId();
				}else {
					return "Usted comentó el comentario con el ID : " + comentario.getidComentarioAComentar();
				}
			}else {
				return "El comentario ingresado tiene más de 256 caracteres";
			}
		}else {
			return "El mail del usuario no existe. Verifique por favor.";
		}
	}
	
	
	
	@GetMapping("/findAllComentarios")
	public List<Comentario> getComentarios(){
		return repositorio.findAll();
		
	}
	
	
	
	
}
