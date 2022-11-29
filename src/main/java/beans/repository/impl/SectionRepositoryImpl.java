package beans.repository.impl;

import beans.repository.SectionRepository;
import entities.Section;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class SectionRepositoryImpl extends AbstractRepository implements SectionRepository {
    @Override
    public List<Section> getSections() {
        return entityManager.createQuery("select section from Section section where section.isDeleted = false", Section.class).
                getResultList();
    }
}
