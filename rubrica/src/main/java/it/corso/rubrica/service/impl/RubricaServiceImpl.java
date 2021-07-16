package it.corso.rubrica.service.impl;

import it.corso.rubrica.model.Contatto;
import it.corso.rubrica.repository.ContattoRepository;
import it.corso.rubrica.service.RubricaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RubricaServiceImpl implements RubricaService {

    @Autowired
    ContattoRepository contattoRepository;

    @Override
    public List<Contatto> aggiungi(Contatto c) {
        if (c != null) {
            contattoRepository.save(c);
        }
        return mostraTutti();
    }

    @Override
    public List<Contatto> rimuovi(Contatto c) {
        if (c.getId() != null) {
           contattoRepository.deleteById(c.getId());
        }
        return mostraTutti();
    }

    @Override
    public List<Contatto> mostraTutti() {
        return contattoRepository.findAll();
    }

}
