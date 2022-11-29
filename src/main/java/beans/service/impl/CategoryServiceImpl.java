package beans.service.impl;

import beans.repository.CategoryRepository;
import beans.service.CategoryService;
import entities.Category;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class CategoryServiceImpl implements CategoryService {
    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }
}
