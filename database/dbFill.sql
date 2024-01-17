\c bank_manager;

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('ООО');

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('ПАО');

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('ЗАО');

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('ИП');

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('Государственное');

INSERT INTO org_legal_forms (org_legal_forms_name)
                     VALUES ('Муниципальное');

INSERT INTO clients (client_name, client_short_name, address, org_legal_forms_id)
             VALUES ('Научно-Исследовательское учреждение Строй-Ломай', 'НИУ Строй-Ломай', 'г. Москва, ул. Библиотечная 6', 1);

INSERT INTO clients (client_name, client_short_name, address, org_legal_forms_id)
             VALUES ('Тестировщики кода Найдёныши', 'Найдёныши', 'г. Санкт-Петербург, ул. Чугунная 15', 4);

INSERT INTO clients (client_name, client_short_name, address, org_legal_forms_id)
             VALUES ('Разработчики кода Чинилы', 'Чинилы', 'г. Пермь, ул. Ленина 78', 4);

INSERT INTO banks (bank_name, bic)
           VALUES ('Тиньбанк', 89678145);

INSERT INTO banks (bank_name, bic)
           VALUES ('Сберкофф', 53473459);

INSERT INTO deposits (client_id, bank_id, opening_date, percent, period_month)
              VALUES (1, 1, '2023-06-20', 10, 36);

INSERT INTO deposits (client_id, bank_id, opening_date, percent, period_month)
              VALUES (2, 1, '2023-10-05', 8, 60);

INSERT INTO deposits (client_id, bank_id, opening_date, percent, period_month)
              VALUES (3, 2, '2023-08-25', 9, 24);


