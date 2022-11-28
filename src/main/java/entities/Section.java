package entities;

import dto.SectionRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Section.TABLE_NAME)
public class Section extends EntityClass {

    public final static String TABLE_NAME = "Section";

    private interface Columns {
        String NAME = "name";
        String DESCRIPTION = "description";
    }

    public Section() {

    }

    public Section(String name, String description) {
        setDescription(description);
        setName(name);
    }

    public Section(SectionRecord record) {
        setName(record.getName());
        setDescription(record.getDescription());
        setId(record.getId());
    }

    @NotNull
    @Column(name = Columns.NAME)
    public String name;

    @NotNull
    @Column(name = Columns.DESCRIPTION)
    public String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Section{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
