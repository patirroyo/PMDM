SELECT p.codigo,
       e.codigo
FROM Proyectos as p
cross join Entidades as e
    ON p.entidad = e.codigo
where p.entidad not in
(select e1.codigo
from Entidades e1
);

select p.entidad
from Proyectos p;

select e.codigo
from Entidades e;

select * from Envios where codigo = '50/072/16';
