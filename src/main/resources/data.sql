DELETE  FROM vaccine;
INSERT INTO vaccine(research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count)
VALUES ('BNT162b2', 'Pfizer-BioTech', 'RNA', 2, 2000);
INSERT INTO vaccine(research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count)
VALUES ('AZD1222', 'AstraZeneca', 'Viral Vector', 2, 1200);
INSERT INTO vaccine(research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count)
VALUES ('mRNA-1273', 'Moderna', 'RNA', 2, 2500);
INSERT INTO vaccine(research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count)
VALUES ('JNJ-78436735', 'Johnson & Johnson', 'Viral Vector', 1, 3400);



DELETE  FROM side_effect;
INSERT INTO side_effect(side_effect_name, description, frequency, vaccine_id)
VALUES ('Redness', 'Some people may have redness on skin', '4% of vaccinated people reported', 1);
INSERT INTO side_effect(side_effect_name, description, frequency, vaccine_id)
VALUES ('Allergy', 'Some people may have some type of allergies', '4% of vaccinated people reported', 1);
INSERT INTO side_effect(side_effect_name, description, frequency,vaccine_id)
VALUES ('Weakness', 'Some people may experience weakness ', '1% of vaccinated people reported',2);
INSERT INTO side_effect(side_effect_name, description, frequency,vaccine_id)
VALUES ('Headache ', 'Some people may experience Headache', '2% of vaccinated people reported',3);
INSERT INTO side_effect(side_effect_name, description, frequency,vaccine_id)
VALUES ('Temperature', 'Some people may experience higer temperature ', '2% of vaccinated people reported',4);

DELETE FROM authority;
INSERT INTO authority (id, name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO  authority (id, name)
VALUES (2, 'ROLE_USER');

DELETE FROM user;
INSERT INTO user (id, username, password, first_name, last_name)
VALUES (1, 'admin', '$2a$12$xBeWZlZECYo9pMjFiZyjtO1GUqulmNWZOWioX0Gl1c961iLUSJYFa', 'John', 'Johnson');
INSERT INTO user (id, username, password, first_name, last_name)
VALUES (2, 'user', '$2a$12$VB3KyQNpEye7EKUnnCBEZ.TPZkopP5MAN8vH86GjKq6erELeXjsC.', 'Peter', 'Peterson');

DELETE FROM user_authority;
INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id)
VALUES (2, 2);