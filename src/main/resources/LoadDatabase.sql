insert into dean (name) values
    ('Roger Calderón'),
    ('Juan Fajardo'),
    ('César Díaz')
;

insert into faculty (name, dean_id) values
    ('Facultad de Ciencias Básicas e Ingeniería', 1),
    ('Facultad de Ciencias Agronómicas', 2),
    ('Facultad de Ciencias Económicas', 3)
    ;

insert into career (name, faculty_id) values
    ('Ingeniería de Sistemas', 1),
    ('Biología', 1),
    ('Ingeniería Electrónica', 1)
    ;

insert into student (name) values
('Miguel Vargas'),
('Fabricio Caicedo'),
('Jonathan Garzon')
;

insert into course (name) values
('Cálculo I'),
('Física I'),
('Programación I')
;

insert into inscription (course_id, student_id) values
(1, 1),
(1, 2), (1, 3)
;

select s.name, c.name from
    course c
    inner join inscription i on c.id = i.course_id
    inner join student s on s.id = i.student_id
where c.name = 'Cálculo I';
