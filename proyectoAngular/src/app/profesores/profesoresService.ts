import { Injectable, isStandalone } from "@angular/core"; // Importar el decorador Injectable
import { Profesor } from "./profesor";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root', // or 'any' if you prefer a different injection scope
  }) // Decorador Injectable
export class ProfesoresService {
    constructor(private http: HttpClient) { }//mediante inyección de dependencias, se inyecta el servicio HttpClient en el constructor de la clase ProfesoresService

    getProfesores(): Observable<Profesor[]> {//metemos el vector de profesores en un objeto observable
        return this.http.get<Profesor[]>('https://localhost:44359/api/Profesor');
    }
    


    /* getProfesores(): Profesor[]{ // Método que devuelve un array de objetos de tipo Profesor
     
     return [
        /* { nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: '2/28/1958', sexo: 'Hombre', nom_padre: 'Juan' },
         { nombre: 'Miguel', apellidos: 'Indurain', direccion: 'Pamplona', fnac: '10/2/1968', sexo: 'Hombre' },
         { nombre: 'Alberto', apellidos: 'Contador', direccion: 'Madrid', fnac: '05/04/1980', sexo: 'Hombre' },
         { nombre: 'María José', apellidos: 'Jiménez', direccion: 'Cuenca', fnac: '12/30/1981', sexo: 'Mujer' },
     ]*/

}