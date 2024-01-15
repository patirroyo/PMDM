import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'el-alumno',
    standalone: true,
    imports: [CommonModule, RouterOutlet], //Esto es para que se pueda usar el *ngIf, SINO NO FUNCIONA Y AGUSTÍN LO HABÍA COMENTADO SIN QUERER xD
    templateUrl: './alumno.component.html', //app/Alumnos/Alumno.component.html
    styleUrl: './alumno.component.css'
})

export class AlumnoComponent {
    columnas: number = 2;
    nombre: string = 'Perico';
    apellidos: string = 'Delagado';
    direccion: string = 'Debajo del acueducto';
    edad: number = 60;
//--------segunda parte--------//
    visibles: boolean = false; //Por defecto la edad y la dirección no saldrán. (Las 2 últimas filas de la tabla). Esto se cambia en la vista HTML con el *ngIf
    
    alternarVisibilidad() {
    this.visibles = !this.visibles;
    }
    
}

