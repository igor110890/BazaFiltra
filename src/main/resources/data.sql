INSERT INTO users (id, age, email, name , password) VALUES (1, 25, 'info@memorynotfound.com', 'admin' , '$2a$12$8FTi1QnxJDM1i/dqtsIkEeWCplhy/ddhwR1fLMR2RJ75KQ1aUd/8W');
INSERT INTO client (id, comments, date_filter_replacement, system_clearing ) VALUES (1, 'бла бла' , 2023-02-03, 'Осмас' );
INSERT INTO client (id, comments, date_filter_replacement, system_clearing ) VALUES (2, 'уга уга' , 2023-03-01, 'Присмус' );


INSERT INTO user_client (user_id, client_id) VALUES (1, 2);

INSERT INTO address_client (client_id, adrress_id) VALUES (1, 1);
INSERT INTO address_client (client_id, adrress_id) VALUES (2, 2);

INSERT INTO telephone_client (client_id, telephone_id) VALUES (1, 1);
INSERT INTO list_of_services_client (client_id, list_of_services_id) VALUES (1, 1);

INSERT INTO address (id, name_address) VALUES (1, 'Николая Отрады 13');
INSERT INTO address (id, name_address) VALUES (2, 'Николая Отрады 11');

INSERT INTO telephone (id, nomer_telephone) VALUES (1, '9375545519');
INSERT INTO list_of_services (id, date, list_of_services) VALUES (1, 2023-04-19, 'ой все');


INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);