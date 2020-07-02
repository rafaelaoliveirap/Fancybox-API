package br.com.fancybox.fancybox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fancybox.fancybox.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
