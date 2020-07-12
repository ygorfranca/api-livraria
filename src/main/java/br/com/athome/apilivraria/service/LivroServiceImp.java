package br.com.athome.apilivraria.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.athome.apilivraria.model.Livro;
import br.com.athome.apilivraria.repository.LivroRepository;

@Service
public class LivroServiceImp implements LivroService{

	private final LivroRepository repository;

	@Autowired
	public LivroServiceImp(LivroRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Livro> findAll() {
		return repository.findAll();
	}

	@Override
	public Livro findById(UUID id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Livro save(Livro livro) {
		Livro novoLivro = new Livro(UUID.randomUUID(), livro.getTitulo(), livro.getDescricao(), livro.getCodigo());
		return repository.save(novoLivro);
	}

	@Override
	public void delete(Livro livro) {
		repository.delete(livro);
	}

	@Override
	public void deleteById(UUID id) {
		repository.delete(findById(id));
	}

	@Override
	public Livro update(Livro livro) {
		return repository.save(livro);
	}
	
}
