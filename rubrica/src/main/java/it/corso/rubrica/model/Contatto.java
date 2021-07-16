package it.corso.rubrica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contatto {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String telefono;

    public Contatto() {
    }

    public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
	public String toString() {
		return "Contatto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", telefono="
				+ telefono + "]";
	}

}
