import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'alumnoTitulo',
    standalone: true
}) 

export class AlumnoTituloPipe implements PipeTransform{
    transform(value: any, sexo: string): string {//devuelve un string
        if (sexo == 'Hombre')
            return "Sr. " + value
        else
            return "Sra. " + value
    }

}