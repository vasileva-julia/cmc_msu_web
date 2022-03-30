package dao;

import models.Course;
import java.util.List;

public interface CourseDAO {
    public void add(Course course);
    public void update(Course course);
    public void delete(Course course);
    public Course getByID(Long id);
    public List<Course> getAll();
}
