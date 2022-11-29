package beans.repository.impl;

import beans.repository.SectionRepository;
import entities.Section;

import java.util.List;

public class SectionRepositoryImpl extends AbstractRepository implements SectionRepository {
    @Override
    public List<Section> getSections() {
        return entityManager.createQuery("select section from Section section where section.isDeleted = false", Section.class).
                getResultList();
    }
}
