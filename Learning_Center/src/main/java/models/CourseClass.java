package models;

import lombok.*;
import java.util.Objects;
import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "class")
public class CourseClass implements java.io.Serializable {

    private Long id;
    private String theme;
    private Time startTime;
    private Time endTime;
    private Course course;

    public CourseClass() {}

    public CourseClass(String theme, Course course) {
        this.theme = theme;
        this.course = course;
    }

    public CourseClass(String theme, Time startTime, Time endTime,
                       Course course) {
        this.theme = theme;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }

    @Id
    @Column(nullable = false, name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "theme")
    public String getTheme() {
        return this.theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column(name = "start_time")
    public Time getStartTime() {
        return this.startTime;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public Time getEndTime() {
        return this.endTime;
    }
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return this.course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CourseClass other = (CourseClass) obj;
        return Objects.equals(id, other.id)
                && course.equals(other.course)
                && theme.equals(other.theme)
                && startTime.equals(other.startTime)
                && endTime.equals(other.endTime);
    }
}
