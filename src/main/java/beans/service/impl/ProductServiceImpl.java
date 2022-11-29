package beans.service.impl;

import beans.repository.ProductRepository;
import beans.service.ProductService;
import entities.Product;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ProductServiceImpl implements ProductService {
    @EJB
    private ProductRepository productRepository;

    @Override
    public Product findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
