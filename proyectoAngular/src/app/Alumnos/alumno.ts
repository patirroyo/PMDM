export interface IAlumno {//Esto es una interfaz que sirve para definir los atributos de un objeto, en este caso de un alumno
    nombre: string;
    apellidos: string;
    direccion: string;
    fnac: string;
    sexo: string;
    nom_padre?: string;//el ? indica que es opcional
    //edad(): number;
}

export class Alumno implements IAlumno {//Esto es una clase que sirve para crear objetos de tipo alumno
    constructor( //al poner el public delante de cada atributo, se crea automáticamente el atributo y se le asigna el valor que se le pasa por parámetro
        public nombre: string,
        public apellidos: string,
        public direccion: string,
        public fnac: string,
        public sexo: string,
        public nom_padre?: string
    ) { }
   /* edad(): number {
        let fechaActual = new Date();
        let fechaNac = new Date(this.fnac);
        let edad = fechaActual.getFullYear() - fechaNac.getFullYear();
        let mes = fechaActual.getMonth() - fechaNac.getMonth();
        if (mes < 0 || (mes === 0 && fechaActual.getDate() < fechaNac.getDate())) {
            edad--;
        }
        return edad;
    }*/

    /*nombre: string;
    apellidos: string;
    direccion: string;
    fnac: string;
    sexo: string;
    constructor(nombre: string, apellidos: string, direccion: string, fnac: string, sexo: string) {
        //el constructor es un método que se ejecuta cuando se crea un objeto de tipo alumno
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fnac = fnac;
        this.sexo = sexo;
    }*/
}