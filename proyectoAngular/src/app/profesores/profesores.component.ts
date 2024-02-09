import { Component } from '@angular/core';
import { ProfesorListaComponent } from './profesorLista.component';

@Component({
  selector: 'app-profesores',
  standalone: true,
  imports: [ProfesorListaComponent],
  templateUrl: './profesores.component.html',
  styleUrl: './profesores.component.css'
})
export class ProfesoresComponent {

}
