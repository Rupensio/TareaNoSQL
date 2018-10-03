package com.javatechie.spring.mongo.api.modelo;





import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comentario")
public class Comentario {

	
	@Id
	@Generated (value = { } )
	private String id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String comentario;
	
	@NotNull
	@Generated (value = { } )
	private String idComentarioAComentar;
	
	
	//Getters
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public String getidComentarioAComentar() {
		return idComentarioAComentar;
	}
	
	
	//Setters
	public void setId(String id) {
		this.id=id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public void setidComentarioAComentar(String idComentarioAComentar) {
		this.idComentarioAComentar = idComentarioAComentar;
	}
	
}
