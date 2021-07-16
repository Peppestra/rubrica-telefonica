package it.corso.rubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.corso.listaspesa.dto.ListaSpesaRichiestaDto;
import it.corso.listaspesa.dto.ListaSpesaRispostaDto;

@CrossOrigin("*")
@RestController
public class rubricaController {

	@Autowired
	RubricaService rs;
	
	@RequestMapping("/aggiungi")
	@ResponseBody
	public RubricaRispostaDto aggiungi(@RequestBody RubricaRichiestaDto dto){
		System.out.println("Service iniettato " + rs.getClass().getName());
		System.out.println("Entrato in aggiungi");
		System.out.println("Ricevuto dto " + dto);
		RubricaRispostaDto risp = new RubricaRispostaDto();
		risp.setListaSpesa(rs.aggiungi(dto.getProdotto()));
		return risp;
}
