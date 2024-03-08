using Colegio2API;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace Colegio2.Controllers
{
    public class AlumnosController : ApiController
    {
        public IEnumerable<Alumnos> Get()//Obtener todos los alumnos
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                return colegio.Alumnos.ToList();
            }
        }
        public Alumnos Get(int id)//Obtener un alumno por id
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                return colegio.Alumnos.Find(id);
            }
        }
        
        [HttpGet]
        public IEnumerable<Alumnos> Filtro(int id)
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                return colegio.Alumnos.Where(a => a.cursoID == id).ToList();
                
            }
        }
        [AcceptVerbs("GET", "DELETE")]
        public IEnumerable<Alumnos> Delete(int id)//Eliminar un alumno por id
        {
            using (Colegio2Entities colegio = new Colegio2Entities())
            {
                Alumnos alumno = colegio.Alumnos.Find(id);
                colegio.Alumnos.Remove(alumno);
                colegio.SaveChanges();
                return colegio.Alumnos.ToList();
            }
        }
    }
}
