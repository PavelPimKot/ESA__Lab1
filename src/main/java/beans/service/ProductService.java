package beans.service;

import entities.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(Integer productId);

    List<Product> getProducts();
}
