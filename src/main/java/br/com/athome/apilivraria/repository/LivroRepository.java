package br.com.athome.apilivraria.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.athome.apilivraria.model.Livro;

/*
 * JPA REPOSITORY já possui muitos métodos prontos para persistencia em banco de dados.
 * */

public interface LivroRepository extends JpaRepository<Livro, UUID> {

	
}
