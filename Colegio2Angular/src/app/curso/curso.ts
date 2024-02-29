export interface ICurso {
    ID: number;
    ano: number;
    letra: string;
}
export class Curso implements ICurso {
    constructor(
        public ID: number,
        public ano: number,
        public letra: string
    ) { }
}