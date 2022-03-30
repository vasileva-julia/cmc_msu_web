package models;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Repository;

import java.util.*;
import javax.persistence.*;

@Entity()
@ToString
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type="long")
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

    public Student() {
    }

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

//    public Long getId() {
//        return this.id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @NonNull
//    @Column(name = "login", nullable = false, length = 250, unique = true)
//    public String getLogin() {
//        return this.login;
//    }
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @Column(name = "password")
//    public String getPassword() {
//        return this.password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_courses",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    public Set<Course> getCourses() {
//        return this.courses;
//    }
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null || getClass() != obj.getClass())
//            return false;
//        Student other = (Student) obj;
//        return Objects.equals(id, other.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return  Objects.hash(id);
//    }
}
