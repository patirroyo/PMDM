import { Routes } from '@angular/router';
import { AlumnoListaComponent } from './Alumnos/alumnoLista.component';
import { ProfesoresComponent } from './profesores/profesores.component';
import { PaginaNoEncontrada } from './otros/paginaNoEncontrada';
import { EjemplosComponent } from './ejemplos/ejemplos.component';
import { AlumnoComponent } from './Alumnos/alumno.component';

export const routes: Routes = [
    { path: 'Alumnos', component: AlumnoListaComponent },
    { path: 'Alumnos/:id', component: AlumnoComponent},
    { path: 'Profesores', component: ProfesoresComponent},
    { path: 'Ejemplos', component: EjemplosComponent},
    { path: '', redirectTo: '/Profesores', pathMatch: 'full'},
    { path: '**', component: PaginaNoEncontrada},
];
