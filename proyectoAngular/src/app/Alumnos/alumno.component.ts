import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnosService } from './alumnosService';
import { ActivatedRoute } from '@angular/router';
import { Alumno } from './alumno';


@Component({
    selector: 'el-alumno',
    standalone: true,
    imports: [CommonModule, RouterOutlet], //Esto es para que se pueda usar el *ngIf, SINO NO FUNCIONA Y AGUSTÍN LO HABÍA COMENTADO SIN QUERER xD
    providers: [AlumnosService],
    templateUrl: './alumno.component.html', //app/Alumnos/Alumno.component.html
    styleUrl: './alumno.component.css'
})

export class AlumnoComponent implements OnInit {
    //primero modificamos la ruta en app.routes.ts para que se pueda acceder a la vista de alumno con un id de alumno
    //--------primera parte sustituido por la llamada a la api con un id de alumno--------//
    /*columnas: number = 2;
    nombre: string = 'Perico';
    apellidos: string = 'Delagado';
    direccion: string = 'Debajo del acueducto';
    edad: number = 60;
    //--------segunda parte--------//
    visibles: boolean = false; //Por defecto la edad y la dirección no saldrán. (Las 2 últimas filas de la tabla). Esto se cambia en la vista HTML con el *ngIf

    alternarVisibilidad() {
        this.visibles = !this.visibles;
    }
*/
    alumno!: Alumno;

    constructor(public alumnoService: AlumnosService, private route: ActivatedRoute) {
    }
    ngOnInit(): void {

        let id: number = this.route.snapshot.params['id'];
        this.alumnoService.getAlumno(id).subscribe((datosAlumno) => this.alumno = datosAlumno);
       
    }
}


