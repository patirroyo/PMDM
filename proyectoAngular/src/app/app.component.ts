import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoComponent } from './Alumnos/alumno.component';
import { AlumnoListaComponent } from './Alumnos/alumnoLista.component';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, AlumnoComponent, AlumnoListaComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'

})
export class AppComponent {
  constructor(private router: Router) {}

  //-----------------la visibilidad----------------//
  isAlumosActive() : string{
    return this.router.url.includes('Alumnos') ? 'active' : '';
  }
  isProfesoresActive() : string{
    return this.router.url.includes('Profesores') ? 'active' : '';
  }
  isEjemplosActive() : string{
    return this.router.url.includes('Ejemplos') ? 'active' : '';
  }

}
