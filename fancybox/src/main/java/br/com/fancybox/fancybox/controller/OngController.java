package br.com.fancybox.fancybox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fancybox.fancybox.model.Ong;
import br.com.fancybox.fancybox.repository.OngRepository;

@RestController
@RequestMapping("/ong") 
@CrossOrigin("*") 
public class OngController {
	
	@Autowired
	private OngRepository repositoryOng;
	
	@GetMapping
	public ResponseEntity<List<Ong>> getAll(){
		return ResponseEntity.ok(repositoryOng.findAll());
	}
	@GetMapping("/ong/{nome}")
	public ResponseEntity<List<Ong>> GetByName(@PathVariable String nome){
		return ResponseEntity.ok(repositoryOng.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Ong> post(@RequestBody Ong ong){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryOng.save(ong));
	}
	
	@PutMapping
	public ResponseEntity<Ong> put(@RequestBody Ong ong){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryOng.save(ong));
	}
	
	
}
