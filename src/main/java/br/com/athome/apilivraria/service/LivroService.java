package br.com.athome.apilivraria.service;

import java.util.List;
import java.util.UUID;

import br.com.athome.apilivraria.model.Livro;

public interface LivroService {
	
	List<Livro> findAll();

	Livro findById(UUID id);

	Livro save(Livro livro);

	void delete(Livro livro);

	void deleteById(UUID id);

	Livro update(Livro livro);
}
