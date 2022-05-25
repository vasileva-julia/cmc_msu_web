package app.models;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString(exclude = {"courses", "id"})
@Table(name = "teacher")
public class Teacher implements GenericModel<Long> {

    public Teacher() {}

    public Teacher(String name, String login, String password,
            Company company, Set<Course> courses) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.company = company;
        this.courses = courses;
    }

    public Teacher(Long id, String name, String login, String password,
                   Company company, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.company = company;
        this.courses = courses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", unique = true, nullable = false)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    @Type(type="org.hibernate.type.IntegerType")
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teachers_courses",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>(0);

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        return (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
