package beans.service.impl;

import beans.repository.ElementRepository;
import beans.service.ElementService;
import entities.Element;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class ElementServiceImpl implements ElementService {
    @EJB
    private ElementRepository elementRepository;

    @Override
    public void save(Element element) {
        elementRepository.save(element);
    }

    @Override
    public void persist(Element element) {
        elementRepository.persist(element);
    }
}
