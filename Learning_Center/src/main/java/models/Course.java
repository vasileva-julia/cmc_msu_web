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

    public Course() {
    }

//    public Course(String name, Time duration, Time intensity, Set<CourseClass> classes)

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "course_id")
//    public Long getId() {
//        return this.id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Column(name = "name")
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Column(name = "duration")
//    public Time getDuration() {
//        return this.duration;
//    }
//    public void setDuration(Time duration) {
//        this.duration = duration;
//    }
//
//    @Column(name = "intensity")
//    public Time getIntensity() {
//        return this.intensity;
//    }
//    public void setIntensity(Time intensity) {
//        this.intensity = intensity;
//    }
//
//    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
//    public Set<CourseClass> getClasses() {
//        return this.classes;
//    }
//    public void setClasses(Set<CourseClass> classes) {
//        this.classes = classes;
//    }
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "teachers_courses",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
//    public Set<Teacher> getTeachers() {
//        return this.teachers;
//    }
//    public void setTeachers(Set<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//
//    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//    public Set<Student> getStudents() {
//        return this.students;
//    }
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null || getClass() != obj.getClass())
//            return false;
//        Course other = (Course) obj;
//        return Objects.equals(id, other.id)
//                && name.equals(other.name)
//                && duration.equals(other.duration)
//                && intensity.equals(other.intensity);
//    }
}
