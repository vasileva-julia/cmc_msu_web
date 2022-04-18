package dao.impl;

import dao.CourseDAO;
import models.Course;


public class CourseDAOImpl extends GenericDAOImpl<Course, Integer> implements CourseDAO {
    public CourseDAOImpl(){
        super(Course.class);
    }
}
