create table if not exists vaccine (
    vaccine_id INT AUTO_INCREMENT  PRIMARY KEY,
    researchName varchar(20) not null,
    manufacturersName varchar(20),
    vaccineType varchar(20) not null,
    requiredDosage int not null,
    availableDosageCount int not null
);