package com.javatechie.spring.mongo.api.repositorio;



import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


import com.javatechie.spring.mongo.api.modelo.Comentario;


@Repository
public interface ComentarioRepositorio extends MongoRepository<Comentario, String> {

	@RestResource(path = "/email", rel = "email" )
	public List<Comentario> findByEmailOrderById(@Param("email")String email);
	
	@RestResource(path = "/idComentario", rel = "idComentario" )
	public List<Comentario> findByIdComentarioAComentarOrderById(@Param("idComentarioAComentar")String idComentarioAComentar);
	
	
}