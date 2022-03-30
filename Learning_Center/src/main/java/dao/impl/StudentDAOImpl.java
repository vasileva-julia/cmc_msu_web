package dao.impl;

import dao.StudentDAO;
import models.Student;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;

public class StudentDAOImpl implements StudentDAO {

//    @Override
//    public void add(Student student) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        System.out.println("----------------------------->>>" + student.getName());
//        session.save(student);
//        session.getTransaction().commit();
//        session.close();
//    }
    @Override
    public void add(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

}

//    public void addStudent(Student student) throws SQLException {
//        // Inserting new entities should not break sequential ordering
//        if (student.getId() != null)
//            student.setId(null);
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();
//        }
//    }
//
//    public void updateStudent(long studentId, Student student) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.update(student);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("StudentUpdate Exception thrown: " + e.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    public Student getStudentById(long id) throws SQLException {
//        Session session = null;
//        Student student = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            student = (Student) session.load(Student.class, id);
//        } catch (Exception e) {
//            System.out.println("getStudentById Exception thrown: " + e.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return student;
//    }
//
//    public void deleteStudent(Student student) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(student);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("deleteStudent Exception thrown: " + e.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    public List<Student> getAllStudents() throws SQLException {
//        Session session = null;
//        List students = new ArrayList<Student>();
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            students = session.createSQLQuery("select * from student as s").addEntity("s", Student.class)
//                    .getResultList();
//        } catch (Exception e) {
//            System.out.println("getAllStudents Exception thrown: " + e.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return students;
//    }
//
//    public List<Student> getStudentsByCourse(Course course) throws SQLException {
//        Session session = null;
//        List<Student> studentList;
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//            long courseId = course.getId();
//            studentList = session.createSQLQuery(
//                    "select * from student as s " +
//                            "inner join users_courses uc on s.student_id = uc.student_id " +
//                            "where course_id = :courseId")
//                    .addEntity("s", Student.class)
//                    .addJoin("c", String.valueOf(Course.class))
//                    .setParameter("courseId", courseId)
//                    .list();
//            session.getTransaction().commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return studentList;
//    }

//    public Student getStudentByName(String name) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//            long courseId = course.getId();
//            Query<"student"> query = session.createQuery("select student ).setParameter("courseId", courseId);
////                            " select b "   // тут поменять запрос !!!!!!!!!!!!!!
////                                    + " from Students s INNER JOIN s.id courses_students"
////                                    + " where course.id = :courseId "
////                    )
//                    .setParameter("courseId", courseId);
//            students = (List<Student>) query.list(); */
//            session.getTransaction().commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//}
