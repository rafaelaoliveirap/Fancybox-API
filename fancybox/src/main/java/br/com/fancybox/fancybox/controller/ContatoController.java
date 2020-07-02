package br.com.fancybox.fancybox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fancybox.fancybox.model.Contato;
import br.com.fancybox.fancybox.repository.ContatoRepository;

@RestController
@RequestMapping("/contato") 
@CrossOrigin("*")
public class ContatoController {
	
	@Autowired
	private  ContatoRepository repository;
	
	@PostMapping
	public ResponseEntity<Contato> post(@RequestBody Contato contato){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(contato));
	}
	

	

}
