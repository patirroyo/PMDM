import { Component } from '@angular/core';

@Component({
    selector: 'el-alumno',
    standalone: true,
    // imports: [],
    templateUrl: './Alumno.component.html', //app/Alumnos/Alumno.component.html
// styleUrl: './app.component.css'
})

export class AlumnoComponent {
    nombre: string = 'Juan';
    apellidos: string = 'Perez';
    direccion: string = 'Calle de la piruleta';
    edad: number = 20;
}