using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace AlbertoSazAPI.Controllers
{
    public class SerieController : ApiController
    {
        public IEnumerable<Series> Get()
        {
            using (ExamenConcesionarioEntities concesionario = new ExamenConcesionarioEntities())
            {
                return concesionario.Series.ToList();
            }
        }
        public Series Get(int id)//Obtener un alumno por id
        {
            using (ExamenConcesionarioEntities concesionario = new ExamenConcesionarioEntities())
            {
                return concesionario.Series.Find(id);
            }
        }

    }
}
