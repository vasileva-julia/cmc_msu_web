package dao.impl;

import dao.CourseDAO;
import models.Course;
import models.Student;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void add(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }
}
