package beans.repository.impl;

import beans.repository.CategoryRepository;
import entities.Category;

import java.util.List;

public class CategoryRepositoryImpl extends AbstractRepository implements CategoryRepository {
    @Override
    public List<Category> getCategories() {
        return entityManager.createQuery("select category from Category category where category.isDeleted = false", Category.class).
                getResultList();
    }
}
