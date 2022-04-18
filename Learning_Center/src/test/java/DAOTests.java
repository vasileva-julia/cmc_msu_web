import dao.*;
import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import util.DAOFactory;
import util.HibernateSessionFactoryUtil;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import org.junit.jupiter.api.TestInstance;
import org.junit.Test;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DAOTests {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    private final DAOFactory instance = DAOFactory.getInstance();
    private final CourseDAO courseDAO = instance.getCourseDAO();
    private final CourseClassDAO courseClassDAO = instance.getCourseClassDAO();
    private final StudentDAO studentDAO = instance.getStudentDAO();
    private final CompanyDAO companyDAO = instance.getCompanyDAO();
    private final TeacherDAO teacherDAO = instance.getTeacherDAO();

    public DAOTests() {}

    @Before
    @AfterAll
    public void clearDB() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery("truncate teachers_courses restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate users_courses restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate teacher restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate class restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate company restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate student restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate course restart identity cascade").executeUpdate();
        session.createSQLQuery("alter sequence company_company_id_seq restart with 1").executeUpdate();
        session.createSQLQuery("alter sequence teacher_teacher_id_seq restart with 1").executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    public void test1() {
        Company company1 = new Company("Sber", "street 666", null);
        Teacher teacher1 = new Teacher("X", "-x", "0000", null, null);
        teacher1.setCompany(company1);
        teacher1.setId(1L);
        DAOFactory.getInstance().getTeacherDAO().add(teacher1);
        Teacher teacher2 = DAOFactory.getInstance().getTeacherDAO().getById(1L);
        assertNotNull(teacher2);
        assertEquals(teacher1.getName(), teacher2.getName());
        assertEquals(teacher1.getId(), teacher2.getId());
        assertEquals(teacher1.getLogin(), teacher2.getLogin());
        DAOFactory.getInstance().getTeacherDAO().delete(teacher1);
        assert(true);
    }

    @Test
    public void test2() {
        Company company1 = new Company("Sber", "street 666", null);
        Teacher teacher1 = new Teacher("X", "-x", "0000", null, null);
        teacher1.setCompany(company1);
        teacher1.setId(1L);
        DAOFactory.getInstance().getTeacherDAO().add(teacher1);
        Teacher teacher2 = DAOFactory.getInstance().getTeacherDAO().getById(1L);
        assertNotNull(teacher2);
        assertEquals(teacher1.getName(), teacher2.getName());
        assertEquals(teacher1.getLogin(), teacher2.getLogin());
        assertEquals((Object) 1L, teacher2.getId());
        assertEquals(teacher1.getPassword(), teacher2.getPassword());
        teacher1.setPassword("new password");
        DAOFactory.getInstance().getTeacherDAO().update(teacher1);
        teacher2 = DAOFactory.getInstance().getTeacherDAO().getById(1L);
        assertEquals("new password", teacher2.getPassword());
        DAOFactory.getInstance().getTeacherDAO().delete(teacher1);
    }

    @Test
    public void test3() {
        Company company = new Company("AD", "ddd", null);
        Teacher teacher1 = new Teacher("X", "-x", "0000", null, null);
        Teacher teacher2 = new Teacher("Y", "-y", "0000", null, null);
        Teacher teacher3 = new Teacher("Z", "-z", "0000", null, null);
        Course course1 = new Course("course1", new BigDecimal("24."), new BigDecimal("2."), null, null, null);
        Course course2 = new Course("course2", new BigDecimal("20.5"), new BigDecimal("3."), null, null, null);
        Course course3 = new Course("course3", new BigDecimal("30."), new BigDecimal("1.5"), null, null, null);
        teacher1.setCompany(company);
        teacher2.setCompany(company);
        teacher3.setCompany(company);
        Set<Course> courses1 = new HashSet<>();
        courses1.add(course1);
        teacher1.setCourses(courses1);
        Set<Course> courses2 = new HashSet<>();
        courses2.add(course1);
        courses2.add(course2);
        teacher2.setCourses(courses2);
        Set<Course> courses3 = new HashSet<>();
        courses2.add(course2);
        courses2.add(course3);
        teacher3.setCourses(courses3);
        Collection<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courseDAO.addAll(courses);
        teacherDAO.add(teacher1);
        teacherDAO.add(teacher2);
        teacherDAO.add(teacher3);
        assertEquals(courses1, teacher1.getCourses());
        List<Teacher> returned_teachers = DAOFactory.getInstance().getTeacherDAO().getByCourseName(new String("course1"));
        System.out.println(returned_teachers);
        List<Teacher> expected_teachers = new ArrayList<>();
        expected_teachers.add(teacher1);
        expected_teachers.add(teacher2);
        assertArrayEquals(expected_teachers.toArray(), returned_teachers.toArray());
    }

    @Test
    public void test4() {
        Course course1 = new Course("course1", new BigDecimal("24."), new BigDecimal("2."), null, null, null);
        CourseClass courseClass = new CourseClass("theme1", new BigDecimal("1000.0"), new BigDecimal("1001.0"), course1);
        courseDAO.add(course1);
        courseClassDAO.add(courseClass);
        CourseClass got_courseClass = courseClassDAO.getById(1L);
        assertEquals((Object) 1L, got_courseClass.getId());
        assertEquals("course1", got_courseClass.getCourse().getName());
        got_courseClass = courseClassDAO.getByCourseName("course1").get(0);
        assertEquals((Object) 1L, got_courseClass.getId());
        assertEquals("course1", got_courseClass.getCourse().getName());
    }

    @Test
    public void test5() {
        Company company1 = new Company("company1", "ddd", null);
        Company company2 = new Company("company2", "ddd", null);
        Teacher teacher = new Teacher("X", "-x", "0000", null, null);
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(teacher);
        company1.setTeachers(teachers);
        company2.setTeachers(teachers);
        Collection<Company> allComp = companyDAO.getAll();
        List<Company> compByTeacher = companyDAO.getByTeacherId(1L);
        assertArrayEquals(allComp.toArray(), compByTeacher.toArray());
    }

    @Test
    public void test6() {
        Course course1 = new Course("course1", new BigDecimal("24."), new BigDecimal("2."), null, null, null);
        Student student = new Student("student", "student", "student", new HashSet<>(0));
        student.getCourses().add(course1);
        courseDAO.add(course1);
        studentDAO.add(student);
        List<Student> students = studentDAO.getByCourseId(1L);
        assertEquals(1, students.size());
        assertEquals(student.getId(), students.get(0).getId());
        assertEquals(student.getName(), students.get(0).getName());
    }
}