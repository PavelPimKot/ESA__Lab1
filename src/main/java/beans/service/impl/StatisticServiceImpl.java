package beans.service.impl;

import beans.repository.StatisticRepository;
import beans.service.StatisticService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Singleton
public class StatisticServiceImpl implements StatisticService {
    @EJB
    private StatisticRepository statisticRepository;

    @Override
    public void writeSalesStatisticInFile(String fileUrl, String fileName) throws IOException {
        File statisticFile = new File(fileUrl, fileName);
        if (statisticFile.isFile()) {
            FileWriter writer = new FileWriter(statisticFile.getAbsolutePath(), false);
            List<Object[]> byProductCount = this.statisticQueryByProductCount();
            List<Object[]> byProductPrice = this.statisticQueryByProductPrice();
            writer.write("Анализ популярности товаров" + "\n");
            for (Object[] obj : byProductCount) {
                writer.write(" id: " + obj[0].toString());
                writer.write(" name: " + obj[1].toString());
                writer.write(" count: " + obj[2].toString());
                writer.write("\n");
            }
            writer.write("Анализ доходности товаров" + "\n");
            for (Object[] obj : byProductPrice) {
                writer.write(" id: " + obj[0].toString());
                writer.write(" name: " + obj[1].toString());
                writer.write(" total profit: " + obj[2].toString());
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }
    }

    @Override
    public List<Object[]> statisticQueryByProductCount() {
        return statisticRepository.statisticQueryByProductCount();
    }

    @Override
    public List<Object[]> statisticQueryByProductPrice() {
        return statisticRepository.statisticQueryByProductPrice();
    }

}
