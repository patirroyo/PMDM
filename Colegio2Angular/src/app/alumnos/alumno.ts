export interface IAlumno {
    ID: number;
    nombre: string;
    apellidos: string;
    direccion: string;
    fnac: string;
    sexo: string;
    cursoID: number;
}

export class Alumno implements IAlumno {//Esto es una clase que sirve para crear objetos de tipo alumno
    constructor( 
        public ID: number,
        public nombre: string,
        public apellidos: string,
        public direccion: string,
        public fnac: string,
        public sexo: string,
        public cursoID: number
    ) { }
}