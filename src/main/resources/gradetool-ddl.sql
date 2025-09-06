-- 1) Lookup-Tabellen
CREATE TABLE gender (
    id      INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    gender  TEXT NOT NULL UNIQUE
);

CREATE TABLE assessmenttype (
    id    INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type  TEXT NOT NULL UNIQUE
);

CREATE TABLE semester (
    id             INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    semester_name  TEXT NOT NULL UNIQUE,
    start_date     DATE NOT NULL,
    end_date       DATE NOT NULL
);

-- 2) Hauptentitaeten
CREATE TABLE person (
    id        INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name      TEXT NOT NULL,
    birthday  DATE NOT NULL,
    gender_id INTEGER NULL REFERENCES gender(id) ON DELETE SET NULL
);

CREATE INDEX idx_person_gender_id ON person (gender_id);

CREATE TABLE course (
    id           INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    course_name  TEXT NOT NULL,
    start_date   DATE NOT NULL,
    end_date     DATE NOT NULL,
    teacher_id   INTEGER NULL REFERENCES person(id) ON DELETE SET NULL,
    semester_id  INTEGER NOT NULL REFERENCES semester(id) ON DELETE CASCADE,
    UNIQUE (course_name, semester_id)
);

CREATE INDEX idx_course_teacher_id  ON course (teacher_id);
CREATE INDEX idx_course_semester_id ON course (semester_id);

CREATE TABLE participant (
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    person_id  INTEGER NOT NULL REFERENCES person(id) ON DELETE CASCADE,
    course_id  INTEGER NOT NULL REFERENCES course(id) ON DELETE CASCADE,
    UNIQUE (person_id, course_id)
);

CREATE INDEX idx_participant_person_id ON participant (person_id);
CREATE INDEX idx_participant_course_id ON participant (course_id);

-- 3) Bewertungen / Noten
CREATE TABLE grade (
    id                INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    participant_id    INTEGER NOT NULL REFERENCES participant(id) ON DELETE CASCADE,
    assessmenttype_id INTEGER NULL REFERENCES assessmenttype(id) ON DELETE SET NULL,
    grade             NUMERIC(2,1) NOT NULL CHECK (grade >= 1.0 AND grade <= 6.0),
    date              DATE NULL,
    assessment_name   TEXT NULL,
    description       TEXT NULL
);

CREATE INDEX idx_grade_participant_id    ON grade (participant_id);
CREATE INDEX idx_grade_assessmenttype_id ON grade (assessmenttype_id);
