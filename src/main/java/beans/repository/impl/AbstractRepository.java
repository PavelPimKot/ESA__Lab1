package beans.repository.impl;

import beans.repository.Repository;
import entities.EntityClass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository implements Repository {

    @PersistenceContext(unitName = "myUnit")
    protected EntityManager entityManager;

    @Override
    public void save(EntityClass entityClass) {
        if (entityClass.getId() != null) {
            entityManager.merge(entityClass);
            return;
        }
        entityManager.persist(entityClass);
    }
}
