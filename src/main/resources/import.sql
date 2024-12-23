-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into myentity (id, field) values(1, 'field-1');
insert into myentity (id, field) values(2, 'field-2');
insert into myentity (id, field) values(3, 'field-3');
alter sequence myentity_seq restart with 4;
insert into booking (id) values(3);


INSERT INTO public.appuser
(id, email, "password", username, image, salt)
VALUES(1, 'jakob', NULL, NULL, NULL, NULL);

INSERT INTO public.car
(baseprice, kilometerprice, seats, id, user_id, description, plate, image)
VALUES(1.0, 1.0, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO public.car
(baseprice, kilometerprice, seats, id, user_id, description, plate, image)
VALUES(1.0, 1.0, 1, 2, 1, NULL, NULL, NULL);