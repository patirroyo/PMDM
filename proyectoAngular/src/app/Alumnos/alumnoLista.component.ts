import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'lista-alumnos',
    standalone: true,
    imports: [CommonModule, RouterOutlet], //Esto es para que se pueda usar el *ngIf, SINO NO FUNCIONA Y AGUSTÍN LO HABÍA COMENTADO SIN QUERER xD
    templateUrl: './alumnoLista.component.html', 
    styleUrl: './alumno.component.css'
})

export class AlumnoListaComponent {
    alumnos: any[] = [
        {nombre: 'Perico', apellidos: 'Delgado', direccion: 'Debajo del acueducto', edad: 60},
        {nombre: 'Miguel', apellidos: 'Indurain', direccion: 'Pamplona', edad: 20},
        {nombre: 'Alberto', apellidos: 'Contador', direccion: 'Madrid', edad: 30},
        {nombre: 'José María', apellidos: 'Jiménez', direccion: 'Chava', edad: 40},
    ];
    
}

