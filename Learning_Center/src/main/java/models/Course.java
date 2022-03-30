package models;

import lombok.*;
import java.util.*;
import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {

    public Course() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "intensity")
    private Time intensity;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseClass> classes = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "teachers_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers = new HashSet<>(0);

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Student> students = new HashSet<>(0);

}
