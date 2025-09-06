INSERT INTO semester (semester_name, start_date, end_date)
VALUES ('Sommersemester 2025', '2025-04-28', '2025-10-25');

INSERT INTO course (course_name, start_date, end_date, semester_id)
VALUES ('Datenbank', '2025-09-10', '2025-12-20', 1);

INSERT INTO gender (gender) VALUES ('male'), ('female');
INSERT INTO assessmenttype (type) VALUES ('Diplomprüfung'), ('Zwischenprüfung');

INSERT INTO person (name, birthday, gender_id)
VALUES ('Lennard Bernet', '2001-07-09', (SELECT id from gender where gender = 'male'));

INSERT INTO person (name, birthday, gender_id)
VALUES ('Milad Fakiry', '1995-01-01', (SELECT id from gender where gender = 'male'));

UPDATE course SET teacher_id = 2 WHERE id = 1;

INSERT INTO participant (person_id, course_id)
VALUES (1, 1);

INSERT INTO grade (grade, assessment_name, description, date, participant_id, assessmenttype_id)
VALUES (5.5, 'Modulprüfung Datenbank', 'Modulprüfung Online mit Google Forms gemacht', '2025-08-31', 1,(SELECT id from assessmenttype where type = 'Diplomprüfung'));

SELECT per.name, per.birthday
FROM participant par
INNER JOIN person per ON per.id = par.person_id
WHERE par.course_id = 1;

SELECT per.name as person_name, c.course_name, g.grade, g.assessment_name, at.type, g.date
FROM grade g
INNER JOIN participant par ON par.id = g.participant_id
INNER JOIN course c ON c.id = par.course_id
INNER JOIN person per ON per.id = par.person_id
LEFT JOIN assessmenttype at ON at.id = g.assessmenttype_id
WHERE per.id = 1;

SELECT c.course_name, s.semester_name, c.start_date, c.end_date
FROM course as c
INNER JOIN semester s ON s.id = c.semester_id;

DELETE from course WHERE id = 1;

DELETE from person WHERE id = 2;

DELETE from grade WHERE id = 1;

SELECT * FROM SEMESTER;
SELECT * FROM COURSE;
SELECT * FROM PERSON;
SELECT * FROM PARTICIPANT;
SELECT * FROM GRADE;
SELECT * FROM ASSESSMENTTYPE;
SELECT * FROM GENDER;
