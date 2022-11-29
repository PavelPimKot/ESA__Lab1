package beans.repository.impl;

import beans.repository.StatisticRepository;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {
    @PersistenceContext(unitName = "myUnit")
    private EntityManager entityManager;

    @Override
    public List<Object[]> statisticQueryByProductCount() {
        return entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();

    }

    @Override
    public List<Object[]> statisticQueryByProductPrice() {
        return entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou*product.price \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();
    }
}
