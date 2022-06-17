package ru.netology.domain;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void add(Product product) {
        if (findById(product.id) != null) {
            throw new AlreadyExistsException("Element with id " + product.id + " alredy exist.");
        } else {
            int length = products.length + 1;
            Product[] tmp = new Product[length];
            System.arraycopy(products, 0, tmp, 0, products.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = product;
            products = tmp;
        }
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found.");
        } else {
            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            products = tmp;
        }
    }
}
