package dao;

import models.Course;
import models.Teacher;

public interface TeacherDAO {
    public void add(Teacher teacher);
    public void update(Teacher teacher);
    public void delete(Teacher teacher);
}
