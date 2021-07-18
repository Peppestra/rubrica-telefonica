package it.corso.rubrica.service;

import it.corso.rubrica.model.Contatto;
import java.util.List;

public interface RubricaService{
	List<Contatto> aggiungi(Contatto c);
	List<Contatto> rimuovi(Contatto c);
	void rimuoviTutti();
	List<Contatto> mostraTutti();
	List<Contatto> cerca(String searchmode, String searchword);
}