package br.com.fancybox.fancybox.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
	
	private long idProduto;
	
	private String nomeProduto;
	
	private String descricao;
	
	private String marca;
	
	private double preco;
	
	private long quantidade;
	
	private String imagem;
	
	private long idCategoria;

}
