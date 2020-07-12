package br.com.athome.apilivraria.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.athome.apilivraria.model.Livro;
import br.com.athome.apilivraria.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Livraria")
@CrossOrigin(origins = "*") //Com a definicao do "*" qualquer domínio acessar a API
public class LivroController {

	private final LivroService service;
	
	@Autowired
	public LivroController(LivroService service) {
		this.service = service;
	}
	

	@GetMapping("/livros")
	@ApiOperation(value = "Retornar uma lista com todos os livros.")
	public List<Livro> listarLivros() {
		return service.findAll();
	}
	
	@GetMapping("/livro/{id}")
	@ApiOperation(value = "Retornar um livro a partir de um ID.")
	public Livro listar(@PathVariable(value="id") UUID id) {
		return service.findById(id);
	}
	
	@PostMapping("/livro")
	@ApiOperation(value = "Salva um livro.")
	public Livro gravar(@RequestBody Livro livro) {
		return service.save(livro);
	}
	
	//Remover o objeto, recebendo atraves JSON
	@DeleteMapping(value = "/livro")
	@ApiOperation(value = "Deleta um livro.")
	public void remover(@RequestBody Livro livro) {
		service.delete(livro);
	}

	@DeleteMapping(value = "/livro/{id}")
	@ApiOperation(value = "Deleta um livro a partir do ID.")
	public void remover(@PathVariable(value = "id") UUID id) {
		service.deleteById(id);
	}
	
	@PutMapping("/livro")
	@ApiOperation(value = "Atualza u livro.")
	public Livro atualizar(@RequestBody Livro livro) {
		return service.update(livro);
	}
	

}
