package com.javatechie.spring.mongo.api.modelo;




import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")

public class Usuario {

	@Id
	@NotNull
	@Email
	private String email;
	
	 	
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
