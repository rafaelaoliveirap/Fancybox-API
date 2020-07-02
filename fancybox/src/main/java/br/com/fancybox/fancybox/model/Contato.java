package br.com.fancybox.fancybox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="contato")
@Data
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idContato;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String assunto;
	
	@Column
	private String mensagem;

}
