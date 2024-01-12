import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { AlumnoComponent } from './Alumnos/alumno.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, AlumnoComponent],
  template: `
<p>{{title}}</p>
<div>
  <h5>Primer ejemplo</h5>
  <h1>{{(encabezado == '')?getNombreCompleto():(5+5)}}</h1>
  <img src='https://cordoba.salesianos.edu/wp-content/uploads/2021/05/{{imagen}}' width="100"><!--las {{}} son para que se interprete como codigo y sirve para los strings-->
  <el-alumno></el-alumno>
  <button [disabled]="desactivado">Boton</button><!-- el [disabled] es para que se desactive el boton se hace con corchetes porque las {{}} son solo para strings-->
</div>
<br><br><h5>Segundo Ejemplo</h5>
<div>
  <button [class]="aplicarClases">Boton 1</button>
  <br><br>
  <button class="color italica negrita"[class.negrita]='false'>Boton 2</button>
  <button class="color italica negrita"[class.negrita]='aplicarNegrita'>Boton 3</button>
  <button class="color italica negrita"[class.negrita]='!aplicarNegrita'>Boton 4</button>
  <br><br>
  <button [ngClass]='addClases()'>Boton 5</button>
</div>
<br><br><br><h5>Tercer Ejemplo</h5>
<div>
  <button (click)="onClick()">Mostrar/Ocultar Bandera</button>
  <br>
  <img src="./assets/Flag_of_Mexico.svg" width="300" *ngIf=visible><!--el *ngIf es para que se muestre la imagen si se cumple la condicion -->
</div>

            `,
  styleUrl: './app.component.css'

})
export class AppComponent {
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
