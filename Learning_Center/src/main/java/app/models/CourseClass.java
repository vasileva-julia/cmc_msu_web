package app.models;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "class")
public class CourseClass implements GenericModel<Long> {

    public CourseClass() {}

    public CourseClass(String theme, Course course) {
        this.theme = theme;
        this.course = course;
    }

    public CourseClass(String theme, BigDecimal startTime, BigDecimal endTime,
                       Course course) {
        this.theme = theme;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }

    @Id
    @Column(nullable = false, name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "start_time")
    private BigDecimal startTime;

    @Column(name = "end_time")
    private BigDecimal endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

}
