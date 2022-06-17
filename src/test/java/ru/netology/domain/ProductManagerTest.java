package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    protected Book book1 = new Book(14, "Преступление и наказание", "Достоевский Ф.М.", 400);
    protected Book book2 = new Book(146, "Герой нашего времени", "Лермонтов М.Ю.", 420);
    protected Book book3 = new Book(210, "Война и мир", "Толстой Л.Н.", 450);
    protected Smartphone smartphone1 = new Smartphone(10, "Iphone 13 Pro", "Apple", 110000);
    protected Smartphone smartphone2 = new Smartphone(48, "Galaxy S21 Ultra", "Samsung", 100000);
    protected Smartphone smartphone3 = new Smartphone(76, "12 Pro", "Xiaomi", 115000);

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    @Test
    public void shouldFindStringInProduct() {

        boolean actual = manager.matches(smartphone1, "Pro");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFind2Items() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Product[] actual = manager.searchBy("Pro");
        Product[] expected = {smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Assertions.assertEquals(book3, repo.findById(210));
    }

    @Test
    public void shouldRemoveFilmById() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(48);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateNotFoundException() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeById(58);
        });
    }

    @Test
    public void shouldAddFilms() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateAlreadyExistException() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(smartphone1);
        });
    }

}
