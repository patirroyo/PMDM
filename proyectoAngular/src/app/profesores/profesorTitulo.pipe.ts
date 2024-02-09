import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'profesorTitulo',
    standalone: true
}) 

export class ProfesorTituloPipe implements PipeTransform{
    transform(value: any, sexo: string): string {//devuelve un string
        if (sexo == 'Hombre')
            return "Sr. " + value
        else
            return "Sra. " + value
    }

}