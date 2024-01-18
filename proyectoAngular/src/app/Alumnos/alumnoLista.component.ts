import { Component, Inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoTituloPipe } from './alumnoTitulo.pipe';
import { pipe } from 'rxjs';

@Component({
    selector: 'lista-alumnos',
    standalone: true,
    imports: [CommonModule, RouterOutlet, AlumnoTituloPipe],
    templateUrl: './alumnoLista.component.html', 
    styleUrl: './alumno.component.css'
})


export class AlumnoListaComponent {
    alumnos: any[] = [
        {nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: '2/28/1958', sexo: 'Hombre'},
        {nombre: 'Miguel', apellidos: 'Indurain', direccion: 'Pamplona', fnac: '10/2/1968', sexo: 'Hombre'},
        {nombre: 'Alberto', apellidos: 'Contador', direccion: 'Madrid', fnac: '05/04/1980', sexo: 'Hombre'},
        {nombre: 'María José', apellidos: 'Jiménez', direccion: 'Cuenca', fnac: '12/30/1981', sexo: 'Mujer'},
    ];
    
}

