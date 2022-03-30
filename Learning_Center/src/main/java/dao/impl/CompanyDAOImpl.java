package dao.impl;

import dao.CompanyDAO;
import models.Company;
import models.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;
import java.util.List;


public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public void add(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company getByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Company> query = session.createQuery("from Company where id = :id_param", Company.class);
        query.setParameter("id_param", id);
        List<Company> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (result.size() == 0)
            return null;
        return (Company) result.get(0);
    }

    @Override
    public List<Company> getByTeacher(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Company> query = session.createQuery("from Company where id = :teacher_param", Company.class);
        query.setParameter("teacher_param", teacher);
        List<Company> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
