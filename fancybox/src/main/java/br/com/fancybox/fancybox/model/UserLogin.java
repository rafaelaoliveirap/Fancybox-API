package br.com.fancybox.fancybox.model;

import lombok.Data;

@Data
public class UserLogin {
	private String nome;
	private String email;	
	private String senha;
	private String token;
	
		
}