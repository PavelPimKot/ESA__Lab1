package beans.repository.impl;

import beans.repository.Repository;
import entities.EntityClass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractRepository implements Repository {

    @PersistenceContext(unitName = "myUnit")
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void save(EntityClass entityClass) {
        if (entityClass.getId() != null) {
            entityManager.merge(entityClass);
            return;
        }
        entityManager.persist(entityClass);
    }
}
