package beans.repository;

import entities.Section;

import java.util.List;

public interface SectionRepository extends Repository{
    List<Section> getSections();
}
