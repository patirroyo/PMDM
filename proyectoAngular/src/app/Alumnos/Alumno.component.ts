import { Component } from '@angular/core';

@Component({
    selector: 'el-alumno',
    standalone: true,
    // imports: [],
    templateUrl: './alumno.component.html', //app/Alumnos/Alumno.component.html
    styleUrl: './alumno.component.css'
})

export class AlumnoComponent {
    columnas: number = 2;
    nombre: string = 'Perico';
    apellidos: string = 'Delagado';
    direccion: string = 'Debajo del acueducto';
    edad: number = 60;
}