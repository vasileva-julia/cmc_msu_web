package Main;

import models.*;
import util.DAOFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Let's begin!");
        SpringApplication.run(Main.class, args);
        Course course = new Course();
        Company c = new Company();
        c.setName("ooo");
        c.setAddress("Fr, 89");
        c.setTeachers(null);
//        DAOFactory.getInstance().getCompanyDAO().add(c);
        Teacher t = new Teacher();
        t.setName("A");
        t.setLogin("A#1");
        t.setPassword("2021");
        t.setCompany(c);
        t.setId(2L);
        DAOFactory.getInstance().getTeacherDAO().add(t);
        DAOFactory.getInstance().getTeacherDAO().delete(t);
        Company old = DAOFactory.getInstance().getCompanyDAO().getByID(2L);
        t.setCompany(old);
        DAOFactory.getInstance().getTeacherDAO().add(t);
        System.out.println("we finished!");
    }
}
