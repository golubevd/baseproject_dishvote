DELETE FROM user_roles;
DELETE FROM dishesofday;
DELETE FROM DISHES;
DELETE FROM users;
DELETE FROM RESTAURANTS;
DELETE FROM VOTES;
ALTER SEQUENCE global_seq
RESTART WITH 100000;
ALTER SEQUENCE rest_seq
RESTART WITH 200000;
ALTER SEQUENCE dish_seq
RESTART WITH 300000;
ALTER SEQUENCE dishofday_seq
RESTART WITH 0;

-- VALUES ('User', 'Smith', 'user@yandex.ru', 'password');
-- PasswordUtil.encode("password");
INSERT INTO users (firstname, lastname, email, password)
VALUES ('User', 'Smith', 'user@yandex.ru', '$2a$10$i09JKq1iXzAYl2o6yLvfBuJYRXhypm9P06voTexk0X6N46qTNt606');

-- VALUES ('Admin', 'Smith', 'admin@gmail.com', 'admin');
-- PasswordUtil.encode("admin");
INSERT INTO users (firstname, lastname, email, password)
VALUES ('Admin', 'Smith', 'admin@gmail.com', '$2a$10$M7C82phiJOuaQSS/ygZVtebkxmsUWEN9ZdTVstJsQcEaRqf2bAz0C');

INSERT INTO users (firstname, lastname, email, password)
VALUES ('User2', 'Smith', 'user2@yandex.ru', '$2a$10$i09JKq1iXzAYl2o6yLvfBuJYRXhypm9P06voTexk0X6N46qTNt606'),
  ('User3', 'Smith', 'user3@yandex.ru', '$2a$10$i09JKq1iXzAYl2o6yLvfBuJYRXhypm9P06voTexk0X6N46qTNt606'),
  ('User4', 'Smith', 'user4@yandex.ru', '$2a$10$i09JKq1iXzAYl2o6yLvfBuJYRXhypm9P06voTexk0X6N46qTNt606');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', (SELECT id
                 FROM USERS
                 WHERE email = 'user@yandex.ru')),
  ('ROLE_ADMIN', (SELECT id
                  FROM USERS
                  WHERE email = 'admin@gmail.com')),
  ('ROLE_USER', (SELECT id
                 FROM USERS
                 WHERE email = 'admin@gmail.com')),
  ('ROLE_USER', (SELECT id
                 FROM USERS
                 WHERE email = 'user2@yandex.ru')),
  ('ROLE_USER', (SELECT id
                 FROM USERS
                 WHERE email = 'user3@yandex.ru')),
  ('ROLE_USER', (SELECT id
                 FROM USERS
                 WHERE email = 'user4@yandex.ru'));

INSERT INTO restaurants (title, address, email, site, REGISTERED) VALUES
  ('debasus''s restaurant', 'Voronezh, 21 Coltsovski str.', 'debasus@mail.ru', 'debasus.ru', now()),
  ('route66''s restaurant', 'Voronezh, 15 Revolution ave.', 'route66@mail.ru', 'route66.ru', now()),
  ('mesto''s restaurant', 'Voronezh, 18 Plehanovskay ave.', 'mesto@mail.ru', 'mesto.ru', now());

INSERT INTO dishes (name, price, registered, restaurant_id) VALUES
  ('lobster', 10000, now(), (SELECT id
                             FROM RESTAURANTS
                             WHERE email = 'route66@mail.ru')),
  ('burger', 2000, now(), (SELECT id
                           FROM RESTAURANTS
                           WHERE email = 'route66@mail.ru')),
  ('borsh', 50000, now(), (SELECT id
                           FROM RESTAURANTS
                           WHERE email = 'route66@mail.ru')),
  ('lobster', 55000, now(), (SELECT id
                             FROM RESTAURANTS
                             WHERE email = 'mesto@mail.ru')),
  ('burger', 2500, now(), (SELECT id
                           FROM RESTAURANTS
                           WHERE email = 'mesto@mail.ru')),
  ('borsh', 30000, now(), (SELECT id
                           FROM RESTAURANTS
                           WHERE email = 'debasus@mail.ru'));

INSERT INTO DISHESOFDAY (datelunch, DISH_ID) VALUES
  (now(),(SELECT id FROM DISHES WHERE name = 'lobster' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru'))),
  (now(),(SELECT id FROM DISHES WHERE name = 'burger' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru'))),
  (now(),(SELECT id FROM DISHES WHERE name = 'borsh' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru'))),
  (now(),(SELECT id FROM DISHES WHERE name = 'lobster' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'mesto@mail.ru'))),
  (now(),(SELECT id FROM DISHES WHERE name = 'burger' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'mesto@mail.ru'))),
  (now(),(SELECT id FROM DISHES WHERE name = 'borsh' and RESTAURANT_ID=(SELECT id FROM RESTAURANTS WHERE email = 'debasus@mail.ru')));

INSERT INTO votes(DATELUNCH, USER_ID, RESTAURANT_ID) VALUES
  (now(),(SELECT id FROM USERS WHERE email = 'user@yandex.ru'), (SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru')),
  (now(),(SELECT id FROM USERS WHERE email = 'admin@gmail.com'),(SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru')),
  (now(),(SELECT id FROM USERS WHERE email = 'user2@yandex.ru'),(SELECT id FROM RESTAURANTS WHERE email = 'route66@mail.ru')),
  (now(),(SELECT id FROM USERS WHERE email = 'user3@yandex.ru'),(SELECT id FROM RESTAURANTS WHERE email = 'mesto@mail.ru')),
(now(),(SELECT id FROM USERS WHERE email = 'user4@yandex.ru'),(SELECT id FROM RESTAURANTS WHERE email = 'debasus@mail.ru'));