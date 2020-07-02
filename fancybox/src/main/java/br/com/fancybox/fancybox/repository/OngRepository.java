package br.com.fancybox.fancybox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fancybox.fancybox.model.Ong;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long>{
	public List<Ong> findAllByNomeContainingIgnoreCase (String nome);

}
