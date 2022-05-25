package app.dao;

import app.models.Teacher;
import java.util.List;

public interface TeacherDAO extends GenericDAO<Teacher, Long> {
    public List<Teacher> getByCourseName(String name);
}
