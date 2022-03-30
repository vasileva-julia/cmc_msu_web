package dao.impl;

import dao.CourseDAO;
import models.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;
import java.util.List;


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

    @Override
    public Course getByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Course> query = session.createQuery("from Course where id = :id_param", Course.class);
        query.setParameter("id_param", id);
        List<Course> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (result.size() == 0)
            return null;
        return (Course) result.get(0);
    }

    @Override
    public List<Course> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Course> query = session.createQuery("from Course", Course.class);
        List<Course> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
