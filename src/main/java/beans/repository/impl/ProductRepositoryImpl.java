package beans.repository.impl;

import beans.repository.ProductRepository;
import entities.Product;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ProductRepositoryImpl extends AbstractRepository implements ProductRepository {
    @Override
    public Product findProductById(Integer productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery(" select product from Product product where  product.count > 0 and product.isDeleted = false", Product.class).getResultList();
    }
}
