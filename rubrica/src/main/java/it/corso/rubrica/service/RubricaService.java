package it.corso.rubrica.service;

import it.corso.rubrica.model.Contatto;
import java.util.List;

public interface RubricaService {

    List<Contatto> aggiungi(Contatto c);

    List<Contatto> rimuovi(Contatto c);

    List<Contatto> mostraTutti();
}