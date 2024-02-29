import { Component, OnInit } from '@angular/core';
import { Alumno } from '../alumnos/alumno';
import { AlumnosService } from '../alumnos/alumnosService';
import { CommonModule } from '@angular/common';
import {  ActivatedRoute, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-alumnos-por-curso',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, AlumnosPorCursoComponent],
  providers: [AlumnosService],
  templateUrl: './alumnos-por-curso.component.html',
  styleUrl: './alumnos-por-curso.component.css'
})
export class AlumnosPorCursoComponent implements OnInit{
  alumnos: Alumno[] = [];


  constructor(public losAlumnos: AlumnosService, private route: ActivatedRoute) { }
  
  ngOnInit(): void {
    let id: number = this.route.snapshot.params['id'];
    this.losAlumnos.getAlumnosPorCurso(id).subscribe(
      (result) => {
        this.alumnos = result;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  refresh(){
    this.ngOnInit();
  }

}
