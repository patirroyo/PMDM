import { Component, Input, Output, EventEmitter } from "@angular/core";
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
    selector: 'cuantos-alumnos',
    standalone: true,
    imports: [CommonModule, RouterOutlet, FormsModule],
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

    //Esto sirve para que se pueda pasar el valor de la variable desde el componente hijo al padre y se carguen los atributos; se pone el @Output() delante de la variable para que se pueda pasar el valor
    
    opcionElegida : string = "Todos";
    
    @Output()
    globalElegido : EventEmitter<string> = new EventEmitter<string>();
}