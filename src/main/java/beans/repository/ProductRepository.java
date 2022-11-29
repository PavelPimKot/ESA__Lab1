package beans.repository;

import entities.Product;

import java.util.List;

public interface ProductRepository extends Repository {

    Product findProductById(Integer productId);

    List<Product> getProducts();
}
