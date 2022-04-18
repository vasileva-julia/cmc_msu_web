package util;

import dao.*;
import dao.impl.*;

public class DAOFactory {

    private static StudentDAO studentDAO = null;
    private static CourseClassDAO courseClassDAO = null;
    private static CompanyDAO companyDAO = null;
    private static TeacherDAO teacherDAO = null;
    private static CourseDAO courseDAO = null;
    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public StudentDAO getStudentDAO(){
        if (studentDAO == null){
            studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }

    public CourseClassDAO getCourseClassDAO(){
        if (courseClassDAO == null){
            courseClassDAO = new CourseClassDAOImpl();
        }
        return courseClassDAO;
    }

    public CompanyDAO getCompanyDAO(){
        if (companyDAO == null){
            companyDAO = new CompanyDAOImpl();
        }
        return companyDAO;
    }

    public TeacherDAO getTeacherDAO(){
        if (teacherDAO == null){
            teacherDAO = new TeacherDAOImpl();
        }
        return teacherDAO;
    }

    public CourseDAO getCourseDAO() {
        if(courseDAO == null) {
            courseDAO = new CourseDAOImpl();
        }
        return courseDAO;
    }
}