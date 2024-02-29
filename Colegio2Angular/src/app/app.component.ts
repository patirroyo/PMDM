import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { CursoComponent } from './curso/curso.component';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, CursoComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Colegio2Angular';
  constructor(private router: Router) {}

  //-----------------la visibilidad----------------//
  isAlumosActive() : string{
    return this.router.url.includes('Alumnos') ? 'active' : '';
  }
  isCursosActive() : string{
    return this.router.url.includes('Cursos') ? 'active' : '';
  }

}

