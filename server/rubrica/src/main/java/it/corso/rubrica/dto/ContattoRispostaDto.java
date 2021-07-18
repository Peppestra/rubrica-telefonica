package it.corso.rubrica.dto;

import it.corso.rubrica.model.Contatto;

public class ContattoRispostaDto{
	private String nome;
	private String cognome;
	private String telefono;

	public ContattoRispostaDto(Contatto c){
		this.nome = c.getNome();
		this.cognome = c.getCognome();
		this.telefono = c.getTelefono();
	}
	public String getNome(){
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public String getTelefono(){
		return this.telefono;
	}
}
