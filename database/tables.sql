drop table if exists teachers_courses;
drop table if exists users_courses;
drop table if exists teacher;
drop table if exists class;
drop table if exists student;
drop table if exists company;
drop table if exists course;

create table student (
    student_id serial primary key,
    name varchar(50) not null ,
    login varchar(20) not null ,
    password varchar(20) not null
);

create table company (
    company_id serial primary key,
    name varchar(50) not null ,
    address varchar(50) not null
);

create table course (
    course_id serial primary key,
    name varchar(250) not null ,
    duration numeric(5, 1) ,
    intensity numeric(5, 1)
);

create table class (
    class_id serial primary key,
    course_id integer references course(course_id),
    theme varchar not null ,
    start_time numeric(5, 1) ,
    end_time numeric(5, 1)
);

create table teacher (
    teacher_id serial primary key,
    company_id integer references company(company_id) not null ,
    name varchar(50) not null ,
    login varchar(20) not null ,
    password varchar(20) not null
);

create table users_courses (
    course_id integer references course(course_id) not null ,
    student_id integer references student(student_id) not null ,
    primary key (course_id, student_id)
);

create table teachers_courses (
    teacher_id integer references teacher(teacher_id) not null ,
    course_id integer references course(course_id) not null ,
    primary key (teacher_id, course_id)
);
