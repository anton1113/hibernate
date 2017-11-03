
create table prime
(
	id int not null auto_increment
		primary key
)
;

create table user
(
	id int not null auto_increment
		primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	phone_number varchar(25) null
)
;

