import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoComponent } from './Alumnos/alumno.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, AlumnoComponent],
  template: `
          <div>
            <h1>{{(encabezado == '')?getNombreCompleto():(5+5)}}</h1>
            <img src='https://cordoba.salesianos.edu/wp-content/uploads/2021/05/{{imagen}}'><!--las {{}} son para que se interprete como codigo y sirve para los strings-->
            <el-alumno></el-alumno>
            <button [disabled]="desactivado">Boton</button><!-- el [disabled] es para que se desactive el boton se hace con corchetes porque las {{}} son solo para strings-->
          </div>
          <br><br><br><br><br><br>
          <button [class]="aplicarClases">Boton 1</button>
          <br><br>
          <button class="color italica negrita"[class.negrita]='false'>Boton 2</button>
          <button class="color italica negrita"[class.negrita]='aplicarNegrita'>Boton 3</button>
          <br><br>
            `,
  styleUrl: './app.component.css'

})
export class AppComponent {
  title: string = 'proyectoAngular de la clase 2ºH';
  encabezado: string = '5';
  imagen: string = 'logo_salesianos.png';


  desactivado: boolean = false;

  nombre: string = 'Perico';
  apellido: string = 'Delgado';


  aplicarClases: string = "italica negrita";
  aplicarNegrita: boolean = true;

  getNombreCompleto(): string {
    return this.nombre + ' ' + this.apellido;
  }

}
