package it.corso.rubrica.serviceImpl;



import it.corso.listaspesa.model.Prodotto;
import it.corso.listaspesa.repository.ProdottoRepository;
import it.corso.listaspesa.service.ListaSpesaService;
import it.corso.rubrica.model.Contatto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class rubricaServiceImpl implements rubricaService {

    @Autowired
    ContattoRepository contattoRepository;

    @Override
    public List<Contatto> aggiungi(Contatto c) {
        if (c.getId() != null) {
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
