package ru.netology.domain;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] findAll() {
        Product[] product = repository.findAll();
        return product;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }
}
