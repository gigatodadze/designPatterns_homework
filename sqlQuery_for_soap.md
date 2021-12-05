 - Create database with query create database countries;
 - Create table with values

use countries;
create table countryCodes(
   id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
   isoCode varchar(50),
   Name varchar(50),
);

 - Insert Data

insert into users values ( 'RU', 'Rubles');
insert into users values ('GE', 'Lari');