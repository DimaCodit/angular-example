CREATE TABLE products
(
    id        bigserial primary key not null,
    is_delete bool         NULL,
    price     int4         NULL,
    title     varchar(255) NULL
);

INSERT INTO products
(is_delete, price, title)
VALUES (false, 66, 'Апельсины'),
       (false, 33, 'Яблоки'),
       (false, 78, 'Мандарины'),
       (false, 69, 'Лимоны'),
       (false, 32, 'Картофель'),
       (false, 24, 'Морковь'),
       (false, 77, 'Шпинат'),
       (false, 25, 'Петрушка'),
       (false, 58, 'Свекла'),
       (false, 33, 'Капуста'),
       (false, 65, 'Огурцы'),
       (false, 77, 'Помидоры'),
       (false, 44, 'Лук репчатый'),
       (false, 33, 'Лук перо'),
       (false, 88, 'Киви'),
       (false, 55, 'Хурма'),
       (false, 43, 'Чеснок'),
       (false, 123, 'Брокколи'),
       (false, 66, 'Редька'),
       (false, 33, 'Редис');