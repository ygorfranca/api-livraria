package br.com.athome.apilivraria.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRARIA")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String titulo;
	private String descricao;
	private long codigo;

	private Livro() {
		
	}
	public Livro(UUID id, String titulo, String descricao, long codigo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public long getCodigo() {
		return codigo;
	}




}
