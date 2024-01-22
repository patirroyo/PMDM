import { Component, Input } from "@angular/core";
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';


@Component({
    selector: 'cuantos-alumnos',
    standalone: true,
    imports: [CommonModule, RouterOutlet],
    templateUrl: './alumnosCount.component.html',
    styleUrl: './alumnosCount.component.css'
})
export class AlumnosCountComponent {
    //Esto sirve para que se pueda pasar el valor de la variable desde el componente padre al hijo y se carguen los atributos; se pone el @Input() delante de la variable para que se pueda pasar el valor
    @Input()
    todos: number = 0;

    @Input()
    hombres: number = 0;

    @Input()
    mujeres: number = 0;
}