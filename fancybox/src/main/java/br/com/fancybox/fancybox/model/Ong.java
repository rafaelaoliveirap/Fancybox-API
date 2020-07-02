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
@Table(name="ong")
@Data
public class Ong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOng;
	
	@NotNull
	@Size(min=2,max=60)
	private String nome;
	
	@Column(unique=true)
	@Size(min=14,max=14)
	private String cnpj;
	
	

	

}
