package br.com.fancybox.fancybox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fancybox.fancybox.dto.ProdutoDTO;
import br.com.fancybox.fancybox.model.Categoria;
import br.com.fancybox.fancybox.model.Produto;
import br.com.fancybox.fancybox.repository.CategoriaRepository;
import br.com.fancybox.fancybox.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/produto") 
@CrossOrigin("*") 
@RequiredArgsConstructor
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private CategoriaRepository repositoryCategoria;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repositoryProduto.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return repositoryProduto.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable long idCategoria){
		Optional<Categoria> categoria =  repositoryCategoria.findById(idCategoria);
		
		return ResponseEntity.ok(repositoryProduto.findByCategoria(categoria));
	}
	
	@PostMapping
	public Produto salvar(@RequestBody ProdutoDTO dto) {
	Long idCategoria = dto.getIdCategoria();
	
	Categoria categoria = 
			repositoryCategoria.findById(idCategoria)
			.orElseThrow(()->
			new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria Inexistente"));
	
	Produto produto = new Produto();
	produto.setCategoria(categoria);
	produto.setNomeProduto(dto.getNomeProduto());
	produto.setDescricao(dto.getDescricao());
	produto.setMarca(dto.getMarca());
	produto.setQuantidade(dto.getQuantidade());
	produto.setPreco(dto.getPreco());
	produto.setImagem(dto.getImagem());
	return repositoryProduto.save(produto);
	}
	
	@PutMapping
	public Produto editar (@RequestBody ProdutoDTO dto) {
		Long idCategoria = dto.getIdCategoria();
		
		Categoria categoria = 
				repositoryCategoria.findById(idCategoria)
				.orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria Inexistente"));
		
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setIdProduto(dto.getIdProduto());
		produto.setNomeProduto(dto.getNomeProduto());
		produto.setDescricao(dto.getDescricao());
		produto.setMarca(dto.getMarca());
		produto.setQuantidade(dto.getQuantidade());
		produto.setPreco(dto.getPreco());
		produto.setImagem(dto.getImagem());
		return repositoryProduto.save(produto);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryProduto.deleteById(id);                                  
	}
	
	
}
