package beans.repository;

import java.util.List;

public interface StatisticRepository {
    List<Object[]> statisticQueryByProductCount();

    List<Object[]> statisticQueryByProductPrice();
}
