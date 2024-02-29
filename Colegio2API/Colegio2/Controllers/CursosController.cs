using Colegio2API;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Colegio2.Controllers
{
    public class CursosController : ApiController
    {
        public IEnumerable<Cursos> Get()//Obtener todos los alumnos
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                return colegio.Cursos.ToList();
            }
        }
        public Cursos Get(int id)//Obtener un alumno por id
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                return colegio.Cursos.Find(id);
            }
        }

    }
}
