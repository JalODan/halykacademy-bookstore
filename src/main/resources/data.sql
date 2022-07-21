-- publisher
INSERT INTO publisher (name)

VALUES
    ('АСТ'),
    ('Эксмо');


-- genre
INSERT INTO genre(name)

VALUES
    ('Исторический роман'),
    ('Мистика'),
    ('Приключения'),
    ('Триллер'),
    ('Детектив'),
    ('Авангардная литература');

-- book
INSERT INTO book (title, release_year, number_of_pages, price, publisher_id)

VALUES
    ('Жук в муравейнике', 2018, 320, 2650, 1),
    ('Пикник на обочине', 2019, 192, 2550, 1),
    ('Забытый эксперимент', 2022, 256, 1350, 1),
    ('От первого лица', 2022, 192, 6514, 2),
    ('Убийство Командора. Книга 2. Ускользающая метафора', 2019, 432, 6924, 2),
    ('Беседы о музыке с Сэйдзи Одзавой', 2020, 320, 7081, 2);

-- author
INSERT INTO author (date_of_birth, fathername, firstname, lastname)

VALUES
    ('1925-08-28', 'Натанович', 'Аркадий', 'Стругацкий'),
    ('1933-04-15', 'Натанович', 'Борис', 'Стругацкий'),
    ('1949-01-01', '', 'Харуки', 'Мураками');


-- book_authors
INSERT INTO book_authors(authors_id, books_id)

VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 4),
    (3, 5),
    (3, 6);


-- book-genres
INSERT INTO book_genres(books_id, genres_id)

VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 4),
    (3, 3),
    (4, 1),
    (4, 2),
    (6, 2);

