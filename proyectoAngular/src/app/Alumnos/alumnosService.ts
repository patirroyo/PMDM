import { Injectable, isStandalone } from "@angular/core"; // Importar el decorador Injectable
import { Alumno } from "./alumno";
import { HttpClientModule } from '@angular/common/http';

@Injectable() // Decorador Injectable
export class AlumnosService{
    getAlumnos(): Alumno[]{ // Método que devuelve un array de objetos de tipo Alumno
    
    return [
       /* { nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: '2/28/1958', sexo: 'Hombre', nom_padre: 'Juan' },
        { nombre: 'Miguel', apellidos: 'Indurain', direccion: 'Pamplona', fnac: '10/2/1968', sexo: 'Hombre' },
        { nombre: 'Alberto', apellidos: 'Contador', direccion: 'Madrid', fnac: '05/04/1980', sexo: 'Hombre' },
        { nombre: 'María José', apellidos: 'Jiménez', direccion: 'Cuenca', fnac: '12/30/1981', sexo: 'Mujer' },*/
    ]
    }
}