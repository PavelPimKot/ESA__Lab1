package beans.repository;

import entities.Element;

public interface ElementRepository {
    void save(Element element);

    void persist(Element element);
}
