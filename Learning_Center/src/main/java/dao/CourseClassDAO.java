package dao;

import models.Course;
import models.CourseClass;
import java.util.List;

public interface CourseClassDAO {
    public void add(CourseClass courseClass);
    public void update(CourseClass courseClass);
    public void delete(CourseClass courseClass);
    public CourseClass getByID(Long id);
    public List<CourseClass> getByCourse(Course course);
}
