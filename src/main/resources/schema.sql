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
