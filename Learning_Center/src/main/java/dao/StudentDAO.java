package dao;

import models.Student;
import models.Course;
import java.util.List;

public interface StudentDAO {
    public void add(Student student);
    public void update(Student student);
    public void delete(Student student);
    public Student getByID(Long id);
    public List<Student> getByCourse(Course course);
}