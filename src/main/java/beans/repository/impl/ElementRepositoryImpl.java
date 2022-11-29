package beans.repository.impl;

import beans.repository.ElementRepository;
import entities.Element;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class ElementRepositoryImpl implements ElementRepository {
    @PersistenceContext(unitName = "myUnit")
    protected EntityManager entityManager;

    @Override
    public void save(Element element) {
       entityManager.merge(element);
    }

    @Override
    public void persist(Element element) {
        entityManager.persist(element);
    }
}
