insert into faculty (name) values
    ('Facultad de Ciencias Básicas e Ingeniería'),
    ('Facultad de Ciencias Agronómicas'),
    ('Facultad de Ciencias Económicas')
    ;

insert into career (name, faculty_id) values
    ('Ingeniería de Sistemas', 1),
    ('Biología', 1),
    ('Ingeniería Electrónica', 1)
    ;

insert into student (name, career_id) values
    ('Miguel Vargas', 1),
    ('Fabricio Caicedo', 1),
    ('Jonathan Garzon', 1)
    ;