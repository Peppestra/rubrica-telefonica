import { Contatto } from './contatto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = "rubrica";
  contatto: Contatto = new Contatto();
  contatti: Contatto[] = [];

  constructor(private http: HttpClient) {
    let ox: Observable<Contatto[]> =
      http.get<Contatto[]>("http://localhost:8080/mostra-tutti");
    ox.subscribe(u => this.contatti = u);
  }

  aggiungi() {
    console.log('Aggiungo Contatti');
    if (this.contatto.nome) {
      let ox: Observable<Contatto[]> =
        this.http.post<Contatto[]>("http://localhost:8080/aggiungi", this.contatto);
      ox.subscribe(u => this.contatti = u);
      this.contatto.nome = "";
      this.contatto.cognome = "";
      this.contatto.telefono = "";
    }
  }

  rimuovi(c: Contatto) {
    console.log('Rimuovo contatto', c);
    let ox: Observable<Contatto[]> =
      this.http.post<Contatto[]>("http://localhost:8080/rimuovi", c);
    ox.subscribe(u => this.contatti = u);
  }
}
