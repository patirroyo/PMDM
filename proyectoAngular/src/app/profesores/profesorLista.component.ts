import { Component, Inject, Input, NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ProfesorTituloPipe } from './profesorTitulo.pipe';
import { ProfesoresCountComponent } from './profesoresCount.component';
import { IProfesor, Profesor } from './profesor';
import { ProfesoresService } from './profesoresService';


@Component({
    selector: 'lista-profesores',
    standalone: true,
    imports: [CommonModule, RouterOutlet, ProfesorTituloPipe, ProfesoresCountComponent],
    providers: [ProfesoresService],
    templateUrl: './profesorLista.component.html',
    styleUrl: './profesores.component.css'
})


export class ProfesorListaComponent implements OnInit{


    seleccion: string = 'Todos';
    profesores: Profesor[] = [];
   
    constructor(public losProfesores: ProfesoresService) { }
    ngOnInit(): void {
        this.losProfesores.getProfesores().subscribe((datosProfesores) => this.profesores = datosProfesores);
    }

    getNumTodos(): number {
        return this.profesores.length;
    }

    getNumHombres(): number {
        return this.profesores.filter(profesor => profesor.sexo === 'Hombre').length;//el === es para la comparación estricta, también compara el tipo de dato
    }

    getNumMujeres(): number {
        return this.profesores.filter(profesor => profesor.sexo === 'Mujer').length;
    }

    alCambiar(opcionSeleccionada: string): void {
        this.seleccion = opcionSeleccionada;
    }

}

