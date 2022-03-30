package dao;

import models.Company;
import models.Course;

public interface CourseDAO {
    public void add(Course course);
    public void update(Course course);
    public void delete(Course course);
}
