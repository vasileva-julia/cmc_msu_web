package models;

import lombok.*;
import org.hibernate.annotations.Type;

import java.util.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course implements GenericModel<Integer> {

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, BigDecimal duration, BigDecimal intensity, Set<CourseClass> classes,
                  Set<Teacher> teachers, Set<Student> students) {
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
        this.classes = classes;
        this.teachers = teachers;
        this.students = students;
    }

    public Course(Integer id, String name, BigDecimal duration, BigDecimal intensity, Set<CourseClass> classes,
                  Set<Teacher> teachers, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
        this.classes = classes;
        this.teachers = teachers;
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    @Type(type="org.hibernate.type.StringType")
    private String name;

    @Type(type="org.hibernate.type.BigDecimalType")
    @Column(name = "duration")
    private BigDecimal duration;

    @Type(type="org.hibernate.type.BigDecimalType")
    @Column(name = "intensity")
    private BigDecimal intensity;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseClass> classes = new HashSet<>(0);

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Teacher> teachers = new HashSet<>(0);

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Student> students = new HashSet<>(0);

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        return (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
