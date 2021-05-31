package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity


@Table(name = "developer", schema = "public", catalog = "deneme")

@NamedQuery(name="DeveloperEntity",query = "select e from DeveloperEntity  e where  DeveloperEntity.name=?1")
public class DeveloperEntity {
    @Override
    public String toString() {
        return "DeveloperEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", university='" + university + '\'' +
                ", planguage='" + planguage + '\'' +
                '}';
    }

    private int id;
    private String name;
    private String surname;
    private String department;
    private String university;
    private String planguage;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Basic
    @Column(name = "planguage")
    public String getPlanguage() {
        return planguage;
    }

    public void setPlanguage(String planguage) {
        this.planguage = planguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperEntity that = (DeveloperEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(department, that.department) && Objects.equals(university, that.university) && Objects.equals(planguage, that.planguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, department, university, planguage);
    }
}
