package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Admin.TABLE_NAME)
public class Admin extends User {

    public final static String TABLE_NAME = "Admins";

    private interface Columns {
        String POSITION = "position";
        String WORK_EXPERIENCE = "workExperience";
        String SALARY = "salary";
    }

    public Admin() {

    }

    public Admin(
            String firstName,
            String lastName,
            String middleName,
            String password,
            String login,
            String phone,
            String position,
            String workExperience,
            int salary) {
        super(firstName, lastName, middleName, password, login, phone);
        setPosition(position);
        setWorkExperience(workExperience);
        setSalary(salary);
    }

    @NotNull
    @Column(name = Columns.POSITION)
    private String position;

    @NotNull
    @Column(name = Columns.WORK_EXPERIENCE)
    private String workExperience;

    @NotNull
    @Column(name = Columns.SALARY)
    private int salary;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                "position='" + position + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", salary=" + salary +
                '}';
    }
}
