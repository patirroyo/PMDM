import { Routes } from '@angular/router';
import { AlumnosPorCursoComponent } from './alumnos-por-curso/alumnos-por-curso.component';
import { CursoComponent } from './curso/curso.component';
import { AlumnosComponent } from './alumnos/alumnos.component';

export const routes: Routes = [
    { path: 'Cursos', component: CursoComponent },
    { path: 'Cursos/:id', component: AlumnosPorCursoComponent },
    { path: 'Alumnos', component: AlumnosComponent},
    { path: '', redirectTo: '/Cursos', pathMatch: 'full'},
    { path: '**', redirectTo: '/Cursos'},
];
