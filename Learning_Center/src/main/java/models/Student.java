package models;

import lombok.*;
import org.hibernate.annotations.Type;
import java.util.*;
import javax.persistence.*;

@Entity()
@Getter
@Setter
@Table(name = "student")
public class Student {

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String login, String password,
                   Set<Course> courses) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.courses = courses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @NonNull
    @Column(nullable = false, name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "login", nullable = false, length = 250, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>(0);

}
