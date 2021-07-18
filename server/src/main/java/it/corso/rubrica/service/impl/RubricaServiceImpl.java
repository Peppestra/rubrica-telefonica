package it.corso.rubrica.service.impl;

import it.corso.rubrica.model.Contatto;
import it.corso.rubrica.repository.ContattoRepository;
import it.corso.rubrica.service.RubricaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService{
	@Autowired
	ContattoRepository contattoRepository;

	@Override
	public List<Contatto> aggiungi(Contatto c){
		if(c != null){
			contattoRepository.save(c);
		}
		return mostraTutti();
	}
	@Override
	public List<Contatto> rimuovi(Contatto c){
		Long id = contattoRepository.findByTelefonoAndCognomeAndNome(c.getTelefono(), c.getCognome(), c.getNome()).getId();
		if(id != null){
			System.out.println("deleting");
			contattoRepository.deleteById(id);
		}
		return mostraTutti();
	}
	@Override
	public void rimuoviTutti(){
		contattoRepository.deleteAllInBatch();
		return;
	}
	@Override
	public List<Contatto> mostraTutti(){
		return contattoRepository.findAllByOrderById();
	}
	@Override
	public List<Contatto> cerca(String searchmode, String searchword){
		if(searchword.isBlank()){
			return mostraTutti();
		}
		else{
			switch(searchmode){
				case("cognome"):
					return contattoRepository.findByCognomeContains(searchword);
				case("telefono"):
					return contattoRepository.findByTelefonoContains(searchword);
				default:
					return contattoRepository.findByNomeContains(searchword);
			}
		}
	}
}
