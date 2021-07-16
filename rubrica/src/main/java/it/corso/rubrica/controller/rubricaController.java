package it.corso.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.corso.rubrica.model.Contatto;
import it.corso.rubrica.service.impl.rubricaServiceImpl;

@CrossOrigin("*")
@RestController
public class rubricaController {

	@Autowired
	rubricaServiceImpl rs;
	
	@RequestMapping("/aggiungi")
	@ResponseBody
	public List<Contatto> aggiungi(@RequestBody Contatto c){
		System.out.println("Service iniettato " + rs.getClass().getName());
		System.out.println("Entrato in aggiungi");
		System.out.println("Ricevuto dto " + c);
		risp.setListaSpesa(rs.aggiungi(dto.getProdotto()));
		return risp;
}
