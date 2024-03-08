using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace AlbertoSazAPI.Controllers
{
    public class VehiculoController : ApiController
    {
        public IEnumerable<Vehiculos> Get()
        {
            using (ExamenConcesionarioEntities concesionario = new ExamenConcesionarioEntities())
            {
                return concesionario.Vehiculos.ToList();
            }
        }
        public Vehiculos Get(int id)
        {
            using (ExamenConcesionarioEntities concesionario = new ExamenConcesionarioEntities())
            {
                return concesionario.Vehiculos.Find(id);
            }
        }

        [HttpGet]
        public IEnumerable<Vehiculos> Filtro(int id)
        {
            using (ExamenConcesionarioEntities concesionario = new ExamenConcesionarioEntities())
            {
                return concesionario.Vehiculos.Where(v => v.SerieId == id).ToList();

            }
        }
       
    }
}