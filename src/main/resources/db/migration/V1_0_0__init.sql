CREATE TABLE categories
(
    id        bigserial primary key not null,
    title     varchar(255) NULL,
    is_delete bool         NULL
);

INSERT INTO categories
(is_delete, title)
VALUES (false, 'Фрукты'),
       (false, 'Овощи'),
       (false, 'Ягоды'),
       (false, 'Зелень');

CREATE TABLE products
(
    id        bigserial primary key not null,
    is_delete bool         NULL,
    price     int4         NULL,
    title     varchar(255) NULL,
    category_id  bigserial,
    FOREIGN KEY(category_id) REFERENCES categories(id)
);

INSERT INTO products
(is_delete, price, title, category_id)
VALUES (false, 66, 'Апельсины', 1),
       (false, 33, 'Яблоки', 1),
       (false, 78, 'Мандарины', 1),
       (false, 69, 'Лимоны', 1),
       (false, 32, 'Картофель', 2),
       (false, 24, 'Морковь', 2),
       (false, 77, 'Шпинат', 4),
       (false, 25, 'Петрушка', 4),
       (false, 58, 'Свекла', 2),
       (false, 33, 'Капуста', 2),
       (false, 65, 'Огурцы', 2),
       (false, 77, 'Помидоры', 2),
       (false, 44, 'Лук репчатый', 4),
       (false, 33, 'Лук перо', 4),
       (false, 88, 'Киви', 1),
       (false, 55, 'Хурма', 1),
       (false, 43, 'Чеснок', 2),
       (false, 123, 'Брокколи', 2),
       (false, 66, 'Редька', 2),
       (false, 33, 'Редис', 2);

create table users (
                       id                    bigserial,
                       username              varchar(30) not null,
                       password              varchar(80) not null,
                       email                 varchar(50) unique,
                       primary key (id)
);

create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email)
values
('user', '$2y$12$4Ml3FeZ3w44aIfocGn4td.4Jxd1.4ZTTW5ygAGk7MD1QWFISPTTQC', 'user@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2);

