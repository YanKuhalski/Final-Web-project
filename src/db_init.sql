CREATE DATABASE IF NOT exists buber;

use buber;

drop table rides;
drop table cars;
drop table users;
drop table discounts;
drop table regions;

create table if not exists discounts (
id int auto_increment not null,
value  decimal (3,2) not null,
primary key(id)
);

create table if not exists users (
 id int auto_increment not null,
 login varchar(20) unique not null,
 password varchar(250) not null , 
 role varchar(10) not null ,
 discount_id int default 1 not null,
 is_active bool default  true not null,
 primary key(id),
 foreign key (discount_id) references discounts(id) on delete no action on update cascade
);

create table if not exists cars (
id int auto_increment not null,
driver_id int not null references users(id) on delete cascade on update cascade ,
car_name varchar(10) not null,
car_model varchar(20) not null,
primary key(id)
);

create table if not exists regions(
id int auto_increment not null,
name varchar(20) not null ,
zone_number int not null ,
primary key(id)
);

create table if not exists rides (
id int auto_increment not null,
client_id int not null,
driver_id int not null,
car_id int not null,
start_region_id int not null ,
end_region_id int not null,
discount_id int not null,
is_accepted bool default false not null,
is_payed bool default false not null,
is_finished bool default false not null,
primary key(id),
foreign key (client_id) references users(id) on delete no action on update cascade,
foreign key (driver_id) references users(id) on delete no action on update cascade,
foreign key (car_id) references cars(id) on delete no action on update cascade,
foreign key (start_region_id) references regions(id) on delete no action on update cascade,
foreign key (end_region_id) references regions(id) on delete no action on update cascade,
foreign key (discount_id) references discounts(id) on delete no action on update cascade
);



insert into regions (name,zone_number) values 
("Ленина",1),
("Первомайская",1),
("Cурганова",2),
("Советская",3),
("Волгоградская",1);
insert into discounts (value) values (1);
insert into users (login,password,role) values
('Yana',md5('client'),'client'),
('Yan',md5('admin'),'admin');



insert into users (login,password,role) values
('Argam',md5('driver'),'driver'),
('Michael',md5('driver'),'driver'),
('Ararat',md5('driver'),'driver'),
('Rudic',md5('driver'),'driver'),
('Ahmed',md5('driver'),'driver'),
('Arcat',md5('driver'),'driver'),
('Bakir',md5('driver'),'driver'),
('Armen',md5('driver2'),'driver'),
('Rustem',md5('driver'),'driver'),
('Gabit',md5('driver'),'driver');

insert into cars (driver_id,car_name,car_model) values 
(3,"BMW","X6"),
(4,"ВАЗ","2107"),
(5,"ВАЗ","2101"),
(6,"ВАЗ","2102"),
(7,"ВАЗ","2103"),
(8,"ВАЗ","2104"),
(9,"ВАЗ","2106"),
(10,"ВАЗ","2107"),
(11,"ВАЗ","2108"),
(12,"ВАЗ","2109");


insert into rides (client_id,driver_id,car_id,start_region_id,end_region_id,discount_id,is_accepted,is_payed,is_finished) values
(1,3,1,1,2,1,true,false,false),
(1,4,1,1,2,1,true,false,true),
(1,3,2,1,2,1,false,false,false);


