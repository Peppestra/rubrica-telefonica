import { Contatto } from './contatto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RichiestaDto } from './richiesta-dto';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent{
	title = 'rubrica';
	contatto: Contatto = new Contatto();
	contatti: Contatto[] = [];
	campoErrore: string = '';
	searchword: string = '';
	searchmode: string = 'nome';
	telefono: string = '';
	nomePattern = '^[A-Z][a-z]+(?: [A-Z][a-z]+)*$';
	cognomePattern = '^[A-Z][a-z]+(?: [A-Z][a-z]+)*$';
	telefonoPattern = '^[0-9]{3}-[0-9]{3}-[0-9]{4}$';

	onStringChange(telefono: string): void{
		if(telefono.length < 8 && telefono.length % 4 == 3){
			this.telefono = telefono + '-';
		}
		this.contatto.telefono = telefono.replace(/-/g, '');
	}

	constructor(private http: HttpClient) {
		let ox: Observable<Contatto[]> =
			http.get<Contatto[]>('http://localhost:8080/mostra-tutti');
		ox.subscribe(u => this.contatti = u);
	}
	resetPopup(){
		setTimeout(() => {
			this.campoErrore = '';
		}, 1500);
	}
	aggiungi(){
		switch(true){
			case this.contatto.nome == '':
				this.campoErrore = 'nome';
				this.resetPopup();
				break;
			case this.contatto.cognome == '':
				this.campoErrore = 'cognome';
				this.resetPopup();
				break;
			case this.contatto.telefono == '':
				this.campoErrore = 'telefono';
				this.resetPopup();
				break;
			default:
				console.log('Aggiungo Contatti');
				let ox: Observable<Contatto[]> =
				this.http.post<Contatto[]>('http://localhost:8080/aggiungi', this.contatto);
				ox.subscribe(c => this.contatti = c);
				this.contatto.nome = '';
				this.contatto.cognome = '';
				this.telefono = '';
				this.contatto.telefono = '';
		}
	}
	conta(){
		console.log('Conto i contatti');
		alert('La rubrica contiene ' + this.contatti.length + (this.contatti.length > 1 ?' contatti': ' contatto'));
	}
	cerca(){
		console.log('Effettuo la ricerca tra i contatti');
		let r: RichiestaDto = new RichiestaDto();
		r.searchmode = this.searchmode;
		r.searchword = this.searchword;
		let ox: Observable<Contatto[]> =
			this.http.post<Contatto[]>('http://localhost:8080/cerca', r);
		ox.subscribe(c => this.contatti = c);
	}
	rimuovi(c: Contatto){
		console.log('Rimuovo contatto', c);
		let ox: Observable<Contatto[]> =
			this.http.post<Contatto[]>('http://localhost:8080/rimuovi', c);
		ox.subscribe(c => this.contatti = c);
		this.contatto.nome = '';
		this.contatto.cognome = '';
		this.telefono = '';
		this.contatto.telefono = '';
	}
	rimuoviTutti(){
		console.log('svuoto rubrica');
		this.http.get<void>('http://localhost:8080/rimuovi-tutti').subscribe(
			() => this.contatti = [],
			console.error
		);
	}
}
