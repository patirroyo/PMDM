import { Injectable, isStandalone } from "@angular/core"; // Importar el decorador Injectable
import { Curso } from "./curso";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root', }) 
export class CursosService {
    constructor(private http: HttpClient) { }

    getCursos(): Observable<Curso[]> {
        return this.http.get<Curso[]>('https://localhost:44358/api/Cursos/Get');
    }


    getCurso(id : number): Observable<Curso> {
        return this.http.get<Curso>('https://localhost:44358/api/Cursos/Get/' + id);
    }

}