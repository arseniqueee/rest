INSERT INTO country (code, name) VALUES (1,'SADAS');
INSERT INTO organization (id, name, address, full_name, inn, kpp, phone, active) values (1, 'New org', 'Adress', 'New org', '132465s8', '4567982', '+7985632148', true);
INSERT INTO office (id, name, org_id, address, phone, active) values (1, 'New office', 1,'address', '+7985632148', true);
insert into docs (code, name) values (14, 'Passport');
insert into docs_data (id, date, docs_code, docs_number) values (1, '1995-12-10', 14, 12345678);
insert into user (id, city_code, doc_code, first_name, identified, last_name, middle_name, office_id, position, second_name) values (1, 1, 1, 'Vasya', true, 'Vasya', 'Vasya', 1, 'position', 'Vasya');
