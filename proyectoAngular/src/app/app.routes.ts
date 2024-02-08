import { Routes } from '@angular/router';
import { AlumnoListaComponent } from './Alumnos/alumnoLista.component';
import { ProfesoresComponent } from './profesores/profesores.component';
import { PaginaNoEncontrada } from './otros/paginaNoEncontrada';

export const routes: Routes = [
    { path: 'Alumnos', component: AlumnoListaComponent },
    { path: 'Profesores', component: ProfesoresComponent},
    { path: '', redirectTo: '/Profesores', pathMatch: 'full'},
    { path: '**', component: PaginaNoEncontrada},
];
