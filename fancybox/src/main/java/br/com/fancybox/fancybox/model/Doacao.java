package br.com.fancybox.fancybox.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="doacao")
@Data
public class Doacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_doacao;
	
	
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(nullable=false)
	private Date dtDoacao = new java.sql.Date(System.currentTimeMillis());
	
	@Column(nullable=false)
	private double valorDoacao;
	
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name="idOng") 
	     private Ong ong;	

	@ManyToOne
	@JoinColumn(name="idUsuario") 
	     private Usuario usuario;

}
