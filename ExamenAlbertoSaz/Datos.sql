INSERT Series (NomSerie) VALUES ('Málaga')
INSERT Series (NomSerie) VALUES ('León')
INSERT Series (NomSerie) VALUES ('Toledo')
INSERT Series (NomSerie) VALUES ('c3')
INSERT Series (NomSerie) VALUES ('Saxo')
INSERT Series (NomSerie) VALUES ('Golf')
INSERT Series (NomSerie) VALUES ('Jetta')
INSERT Series (NomSerie) VALUES ('F-150')
INSERT Series (NomSerie) VALUES ('LaFerrari')
INSERT Series (NomSerie) VALUES ('Focus')

INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('TE-5498-D', 'Verde', 1)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('9862 DGC', 'Negro', 2)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('1234 ABC', 'Rojo', 3)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('9876 CRE', 'Verde', 4)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('Z-0000-AC', 'Negro', 5)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('0030 LHY', 'Blanco', 6)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('4414 FCZ', 'Verde', 7)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('231-IT-2', 'Rojo', 8)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('1234 CBA', 'Rojo', 9)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('4478 FCZ', 'Blanco', 10)
INSERT Vehiculos (Matricula, Color, SerieId) VALUES ('1232 URC', 'Gris', 1)


-- Para generar hasta 150 vehículos variados

-- Insertar vehículos adicionales para cada serie existente
DECLARE @i INT = 0;
WHILE @i < 140
BEGIN
    INSERT Vehiculos (Matricula, Color, SerieId)
    VALUES 
    (
        -- Generar matrícula aleatoria
        CASE 
            WHEN @i % 3 = 0 THEN CONCAT(CHAR(65 + @i % 26), CHAR(65 + (@i + 5) % 26), '-', CONVERT(NVARCHAR, 1000 + @i % 900), '-', CHAR(65 + (@i + 10) % 26))
            WHEN @i % 3 = 1 THEN CONCAT(CHAR(65 + (@i + 7) % 26), '-', CONVERT(NVARCHAR, 1000 + (@i + 2) % 900), '-', CHAR(65 + (@i + 15) % 26))
            ELSE CONCAT(CHAR(65 + (@i + 5) % 26), CHAR(65 + (@i + 12) % 26), '-', CONVERT(NVARCHAR, 1000 + (@i + 3) % 900), '-', CHAR(65 + (@i + 20) % 26))
        END,
        -- Generar color aleatorio
        CASE 
            WHEN @i % 3 = 0 THEN 'Azul'
            WHEN @i % 3 = 1 THEN 'Gris'
            ELSE 'Negro'
        END,
        -- Seleccionar SerieId aleatorio
        1 + @i % 10
    );
    SET @i = @i + 1;
END;