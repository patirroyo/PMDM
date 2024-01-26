import { Component, Inject, Input, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoTituloPipe } from './alumnoTitulo.pipe';
import { AlumnosCountComponent } from './alumnosCount.component';
import { IAlumno, Alumno } from './alumno';


@Component({
    selector: 'lista-alumnos',
    standalone: true,
    imports: [CommonModule, RouterOutlet, AlumnoTituloPipe, AlumnosCountComponent],
    templateUrl: './alumnoLista.component.html',
    styleUrl: './alumno.component.css'
})


export class AlumnoListaComponent {
    //recibe el valor del hijo

    seleccion: string = 'Todos';//Esto es para que por defecto se muestren todos los alumnos, pero se puede cambiar a Hombres o Mujeres por medio del select que envia un evento al padre(donde estamos) y se cambia el valor de la variable seleccion
    //alumnos: IAlumno[];//Esto es un array de objetos de tipo IAlumno, que es una interfaz que hemos creado en alumno.ts y tengo que importarla arriba
    alumnos: Alumno[];
    constructor() {
        this.alumnos = [
            { nombre: 'Perico', apellidos: 'Delgado', direccion: 'Segovia', fnac: '2/28/1958', sexo: 'Hombre', nom_padre: 'Juan' },
            { nombre: 'Miguel', apellidos: 'Indurain', direccion: 'Pamplona', fnac: '10/2/1968', sexo: 'Hombre' },
            { nombre: 'Alberto', apellidos: 'Contador', direccion: 'Madrid', fnac: '05/04/1980', sexo: 'Hombre' },
            { nombre: 'María José', apellidos: 'Jiménez', direccion: 'Cuenca', fnac: '12/30/1981', sexo: 'Mujer' },
        ];
    }

    getNumTodos(): number {
        return this.alumnos.length;
    }

    getNumHombres(): number {
        return this.alumnos.filter(alumno => alumno.sexo === 'Hombre').length;//el === es para la comparación estricta, también compara el tipo de dato
    }

    getNumMujeres(): number {
        return this.alumnos.filter(alumno => alumno.sexo === 'Mujer').length;
    }

    alCambiar(opcionSeleccionada: string): void {
        this.seleccion = opcionSeleccionada;
    }

}

