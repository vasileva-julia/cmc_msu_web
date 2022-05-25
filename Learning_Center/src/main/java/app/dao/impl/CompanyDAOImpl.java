package app.dao.impl;

import app.dao.CompanyDAO;
import app.models.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;
import app.util.HibernateSessionFactoryUtil;
import java.util.List;


public class CompanyDAOImpl extends GenericDAOImpl<Company, Long> implements CompanyDAO {

    public CompanyDAOImpl() { super(Company.class); }

    @Override
    public List<Company> getByTeacherId(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Company> query = session.createQuery(
                "SELECT c FROM Company c INNER JOIN c.teachers t WHERE t.id = :teacher_id_param", Company.class);
        query.setParameter("teacher_id_param", id);
        List<Company> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
