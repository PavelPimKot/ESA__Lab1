package beans.service.impl;

import beans.repository.SectionRepository;
import beans.service.SectionService;
import entities.Section;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class SectionServiceImpl implements SectionService {
    @EJB
    private SectionRepository sectionRepository;

    @Override
    public List<Section> getSections() {
        return sectionRepository.getSections();
    }
}
