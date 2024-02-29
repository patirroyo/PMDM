import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnosService } from './alumnosService';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-alumnos',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  providers: [AlumnosService],
  templateUrl: './alumnos.component.html',
  styleUrl: './alumnos.component.css'
})
export class AlumnosComponent implements OnInit {

  alumnos: Alumno[] = [];

  @Input()
  seleccionado: number = 0;

  constructor(public losAlumnos: AlumnosService) { }

  ngOnInit(): void {
    this.losAlumnos.getAlumnos().subscribe(
      (result) => {
        this.alumnos = result;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  borrarAlumno(id: number) {
    this.losAlumnos.borrarAlumno(id).subscribe(
      (result) => {
        this.alumnos = result;
      },
      (error) => {
        console.log(error);
      }
    );
  }



}