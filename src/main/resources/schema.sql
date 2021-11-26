drop table if exists vaccine;
create table if not exists vaccine (
    vaccine_id INT AUTO_INCREMENT ,
    research_name varchar(20) not null,
    manufacturers_name varchar(20) UNIQUE not null ,
    vaccine_type varchar(20) not null,
    required_dosage int not null,
    available_dosage_count int not null,
    PRIMARY KEY (vaccine_id)

);


drop table if exists side_effect;
create table if not exists side_effect (
    side_effect_id INT AUTO_INCREMENT,
    side_effect_name varchar(50) not null,
    description varchar(100) not null,
    frequency varchar(100) not null,
    vaccine_id int ,
    PRIMARY KEY (side_effect_id),
    FOREIGN KEY (vaccine_id) REFERENCES vaccine (vaccine_id)
);

drop table if exists user;
create table if not exists user (
    id identity,
    username varchar(100) not null,
    password varchar(250) not null,
    first_name varchar(250) not null,
    last_name varchar(250) not null
    );

drop table if exists authority;
create table if not exists authority (
       id identity,
       name varchar(100) not null
    );

create table if not exists user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
    );