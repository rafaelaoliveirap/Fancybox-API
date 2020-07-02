package br.com.fancybox.fancybox.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DoacaoDTO {
	
	
	private long idDoacao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtDoacao = new java.sql.Date(System.currentTimeMillis());
	
	private double valorDoacao;
	
	private String email;
	
	 private long idOng;	
	 
	 private long idUsuario;

}
