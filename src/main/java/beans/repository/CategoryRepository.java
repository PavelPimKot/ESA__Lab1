package beans.repository;

import entities.Category;

import java.util.List;

public interface CategoryRepository extends Repository {
    public static final String JNDI_NAME = "CategoryRepository";
    List<Category> getCategories();
}
