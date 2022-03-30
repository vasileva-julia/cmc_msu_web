package dao;

import models.Course;
import models.Teacher;
import java.util.List;

public interface TeacherDAO {
    public void add(Teacher teacher);
    public void update(Teacher teacher);
    public void delete(Teacher teacher);
    public Teacher getByID(Long id);
    public List<Teacher> getByCourse(Course course);
}
