package dao;

import models.Student;
import java.util.List;

public interface StudentDAO extends GenericDAO<Student, Long> {
    public List<Student> getByCourseId(Long id);
}