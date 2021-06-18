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

