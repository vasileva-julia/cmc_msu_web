package dao.impl;

import dao.StudentDAO;
import models.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {

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

    @Override
    public Student getByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Student> query = session.createQuery("from Student where id = :id_param", Student.class);
        query.setParameter("id_param", id);
        List<Student> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (result.size() == 0)
            return null;
        return (Student) result.get(0);
    }

    @Override
    public List<Student> getByCourse(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Student> query = session.createQuery("from Student where :course_param in courses", Student.class);
        query.setParameter("course_param", course);
        List<Student> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
