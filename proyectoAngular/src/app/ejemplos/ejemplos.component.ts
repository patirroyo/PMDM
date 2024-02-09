import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoComponent } from '../Alumnos/alumno.component';
import { AlumnoListaComponent } from '../Alumnos/alumnoLista.component';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-ejemplos',
  standalone: true,
  imports: [CommonModule, RouterOutlet, AlumnoComponent, AlumnoListaComponent, HttpClientModule],
  templateUrl: './ejemplos.component.html',
  styleUrl: './ejemplos.component.css'
})
export class EjemplosComponent {
  

  //-----------------Primer ejemplo----------------//
  title: string = 'proyectoAngular de la clase 2ºH';
  encabezado: string = '5';
  imagen: string = 'logo_salesianos.png';

  desactivado: boolean = false;

  nombre: string = 'Perico';
  apellido: string = 'Delgado';


  getNombreCompleto(): string {
    return this.nombre + ' ' + this.apellido;
  }

  //-----------------Segundo ejemplo----------------//

  aplicarClases: string = 'italica negrita';
  aplicarNegrita: boolean = true;
  aplicaColor: boolean = true;

  addClases() {
    let clases = {//esto es un objeto de javascript que se puede poner en el html con [ngClass] 
      negrita: this.aplicarNegrita, //el nombre de la clase es negrita y el valor es el de la variable aplicarNegrita 
      color: this.aplicaColor
    }
    return clases;
  }
  //-----------------Tercer ejemplo----------------//
  visible: boolean = false;
  onClick(){
    this.visible = !this.visible;
  }
}
