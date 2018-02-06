import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(" +
                " id=" + id +
                " name=" + name +
                " surname=" + surname +
                " age=" + age +
                ")";
    }
}
