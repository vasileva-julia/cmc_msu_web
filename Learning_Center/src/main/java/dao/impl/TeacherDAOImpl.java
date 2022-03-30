package dao.impl;

import dao.TeacherDAO;
import models.Course;
import models.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;
import java.util.List;


public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public void add(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Teacher getByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Teacher> query = session.createQuery("from Teacher where id = :id_param", Teacher.class);
        query.setParameter("id_param", id);
        List<Teacher> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (result.size() == 0)
            return null;
        return (Teacher) result.get(0);
    }

    @Override
    public List<Teacher> getByCourse(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Teacher> query = session.createQuery("from Teacher where :course_param in courses", Teacher.class);
        query.setParameter("course_param", course);
        List<Teacher> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
