﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace AlumnosAPI.Controllers
{
    public class AlumnoController : ApiController
    {
        public IEnumerable<Alumnos> Get()//Obtener todos los alumnos
        {
            using(ColegioEntities colegio = new ColegioEntities())
            {
                return colegio.Alumnos.ToList();
            }
        }
        public Alumnos Get(int id)//Obtener un alumno por id
        {
            using(ColegioEntities colegio = new ColegioEntities())
            {
                return colegio.Alumnos.Find(id);
            }
        }
    }
}
