create database tta_db;

drop table titles;

create table titles(
   title_id serial primary key ,
   title VARCHAR(100) NOT NULL,
   title_text VARCHAR(500) NOT NULL,
   title_submission_date DATE,
   title_text_score INT
);
