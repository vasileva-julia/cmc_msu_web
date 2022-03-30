package dao;

import models.Student;
import models.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.sql.SQLException;

@Repository
public interface StudentDAO {
    public void add(Student student);
    public void update(Student student);
    public void delete(Student student);
//    public List<Student> getAllStudents() throws SQLException;
//    public Student getStudentById(long id) throws SQLException;
//    public List<Student> getStudentsByCourse(Course course) throws SQLException;
////    public Student getStudentByName(String name) throws  SQLException;
}