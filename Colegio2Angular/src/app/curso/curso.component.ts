import { Component, OnInit } from '@angular/core';
import { CursosService } from './cursoService';
import { Curso } from './curso';
import { ActivatedRoute, RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AlumnosComponent } from '../alumnos/alumnos.component';
import { AlumnosPorCursoComponent } from '../alumnos-por-curso/alumnos-por-curso.component';

@Component({
  selector: 'app-curso',
  standalone: true,
  imports: [CommonModule, AlumnosComponent, RouterOutlet, RouterModule, AlumnosPorCursoComponent],
  providers: [CursosService],
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css'
})
export class CursoComponent implements OnInit {

  cursos: Curso[] = [];
  seleccionado: number = 0;

  constructor(public losCursos: CursosService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id: number = this.route.snapshot.params['id'];
    if (id != undefined) {
      this.losCursos.getCurso(id).subscribe((datosCurso) => this.cursos = [datosCurso]);
      this.seleccionado = id;
    }else{
      this.losCursos.getCursos().subscribe(
        (result) => {
          this.cursos = result;
        },
        (error) => {
          console.log(error);
        }
      );
    }

  }
  onChange(c: string) {
    this.seleccionado = Number(c);
  }

}
