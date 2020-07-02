package br.com.fancybox.fancybox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fancybox.fancybox.model.Categoria;
import br.com.fancybox.fancybox.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findByCategoria (Optional<Categoria> categoria);

}
