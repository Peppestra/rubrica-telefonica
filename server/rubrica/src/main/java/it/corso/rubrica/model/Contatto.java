package it.corso.rubrica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = {
	@Index(columnList = "nome"),
	@Index(columnList = "telefono", unique = true),
	@Index(columnList = "cognome, nome", unique = true)
})
public class Contatto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String telefono;

	public Contatto(){
	}
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public void setCognome(String cognome){
		this.cognome = cognome;
	}
	public String getTelefono(){
		return this.telefono;
	}
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	@Override
	public String toString(){
		return "Contatto [id=" + this.id + ", nome=" + this.nome + ", cognome=" + this.cognome + ", telefono="
				+ this.telefono + "]";
	}
}
