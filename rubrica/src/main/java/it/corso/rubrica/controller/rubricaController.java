package it.corso.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.corso.rubrica.model.Contatto;
import it.corso.rubrica.service.impl.RubricaServiceImpl;

@CrossOrigin("*")
@RestController
public class rubricaController {

	@Autowired
	RubricaServiceImpl rs;
	
	@RequestMapping("/aggiungi")
	@ResponseBody
	public List<Contatto> aggiungi(@RequestBody Contatto c){
		return rs.aggiungi(c);
	}
	
	@RequestMapping("/rimuovi")
	@ResponseBody
	public List<Contatto> rimuovi(@RequestBody Contatto c){
		return rs.rimuovi(c);
	}
	
	@RequestMapping("/mostra-tutti")
	@ResponseBody
	public List<Contatto> mostraTutti(@RequestBody Contatto c){
		return rs.mostraTutti();
	}
}
