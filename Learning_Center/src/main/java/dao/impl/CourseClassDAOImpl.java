package dao.impl;

import dao.CourseClassDAO;
import models.Course;
import models.CourseClass;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;


public class CourseClassDAOImpl extends GenericDAOImpl<CourseClass, Long> implements CourseClassDAO {

    public CourseClassDAOImpl(){
        super(CourseClass.class);
    }

    public List<CourseClass> getByCourseName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CourseClass> cq = cb.createQuery(CourseClass.class);
        Metamodel m = session.getMetamodel();
        EntityType<CourseClass> CourseClass_ = m.entity(CourseClass.class);
        Root<CourseClass> courseClass = cq.from(CourseClass_);
        Join<CourseClass, Course> course = courseClass.join("course");
        cq.select(courseClass).where(cb.like(course.get("name"), name));
        Query<CourseClass> query = session.createQuery(cq);
        List<CourseClass> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
