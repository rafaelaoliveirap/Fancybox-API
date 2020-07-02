package br.com.fancybox.fancybox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	

	@NotNull
	@Size(min=2,max=50)
	private String nome;
	
	@NotNull
	@Size(min=2,max=60)
	private String sobrenome;
	
	@NotNull
	@Size(min=11,max=11)
	@Column(unique=true)
	private String cpf;
	
	@NotNull
	@Size(min=9,max=100)
	@Column(unique=true)
	private String email;
	
	@NotNull
	
	private String senha;
	
	@NotNull
	@Size(min=5, max=120)
	private String logradouro;
	
	@NotNull
	@Size(min=2,max=60)
	private String bairro;
	
	@NotNull
	@Size(min=3, max=60)
	private String cidade;
	
	@NotNull
	@Size(min=2,max=2)
	private String estado;
	
	@NotNull
	@Size(min=3, max=60)
	private String complemento;
	
	@NotNull
	@Size(min=8,max=8)
	private String cep;

	

}