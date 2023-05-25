create table if not exists customer(
    id int auto_increment primary key,
    name varchar(100) not null,
    address varchar(250) not null,
    contact varchar(20) not null

);

alter table customer add constraint uk_contact unique (contact);

create table if not exists item(
    `code` int auto_increment primary key,
    `description` varchar(250) not null,
    quantity int not null,
    price decimal not null

);