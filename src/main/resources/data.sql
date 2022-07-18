-- publisher
INSERT INTO publisher (name)

VALUES
    ('АСТ');

-- book
INSERT INTO book (title, release_year, number_of_pages, price, publisher_id)

VALUES
    ('Жук в муравейнике', 2018, 320, 2650, 1),
    ('Пикник на обочине', 2019, 192, 2550, 1),
    ('Забытый эксперимент', 2022, 256, 1350, 1);

-- author
INSERT INTO author (date_of_birth, fathername, firstname, lastname)

VALUES
    ('1925-08-28', 'Натанович', 'Аркадий', 'Стругацкий'),
    ('1933-04-15', 'Натанович', 'Борис', 'Стругацкий');


-- book_authors
INSERT INTO book_authors(authors_id, books_id)

VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3);