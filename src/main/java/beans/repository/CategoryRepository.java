package beans.repository;

import entities.Category;

import java.util.List;

public interface CategoryRepository extends Repository{
    List<Category> getCategories();
}
