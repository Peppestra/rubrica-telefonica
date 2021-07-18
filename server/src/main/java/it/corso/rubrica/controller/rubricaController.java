package it.corso.rubrica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.corso.rubrica.dto.ContattoRispostaDto;
import it.corso.rubrica.dto.RicercaContattoRichiestaDto;
import it.corso.rubrica.model.Contatto;
import it.corso.rubrica.service.RubricaService;

@CrossOrigin("*")
@RestController
public class rubricaController{
	@Autowired
	RubricaService rs;

	@RequestMapping("/aggiungi")
	@ResponseBody
	public List<ContattoRispostaDto> aggiungi(@RequestBody Contatto contatto){
		List<ContattoRispostaDto> contatti = new ArrayList<ContattoRispostaDto>();
		rs.aggiungi(contatto).stream().forEach(c -> contatti.add(new ContattoRispostaDto(c)));
		return contatti;
	}
	@RequestMapping("/rimuovi")
	@ResponseBody
	public List<ContattoRispostaDto> rimuovi(@RequestBody Contatto contatto){
		List<ContattoRispostaDto> contatti = new ArrayList<ContattoRispostaDto>();
		rs.rimuovi(contatto).stream().forEach(c -> contatti.add(new ContattoRispostaDto(c)));
		return contatti;
	}
	@RequestMapping("/rimuovi-tutti")
	public void rimuoviTutti(){
		rs.rimuoviTutti();
		return;
	}
	@RequestMapping("/mostra-tutti")
	public List<ContattoRispostaDto> mostraTutti(){
		List<ContattoRispostaDto> contatti = new ArrayList<ContattoRispostaDto>();
		rs.mostraTutti().stream().forEach(c -> contatti.add(new ContattoRispostaDto(c)));
		return contatti;
	}
	@RequestMapping("/cerca")
	@ResponseBody
	public List<ContattoRispostaDto> cerca(@RequestBody RicercaContattoRichiestaDto dto){
		List<ContattoRispostaDto> contatti = new ArrayList<ContattoRispostaDto>();
		rs.cerca(dto.getSearchmode(), dto.getSearchword()).stream().forEach(c -> contatti.add(new ContattoRispostaDto(c)));
		return contatti;
	}
}
