import java.util.concurrent.TimeUnit;

import app.models.Company;
import app.models.Course;
import app.models.Student;
import app.models.Teacher;
import app.util.DAOFactory;
import app.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.TestInstance;
import org.junit.Test;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTests {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    private final DAOFactory instance = DAOFactory.getInstance();

    public SeleniumTests() {}

    @Before
    @AfterEach
    public void clearDB() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery("truncate teachers_courses restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate users_courses restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate teacher restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate class restart identity cascade ").executeUpdate();
        session.createSQLQuery("truncate company restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate student restart identity cascade").executeUpdate();
        session.createSQLQuery("truncate course restart identity cascade").executeUpdate();
        session.createSQLQuery("alter sequence company_company_id_seq restart with 1").executeUpdate();
        session.createSQLQuery("alter sequence teacher_teacher_id_seq restart with 1").executeUpdate();
        session.createSQLQuery("alter sequence student_student_id_seq restart with 1").executeUpdate();
        session.createSQLQuery("alter sequence class_class_id_seq restart with 1").executeUpdate();
        session.createSQLQuery("alter sequence course_course_id_seq restart with 1").executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    public void testMainPage() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        Assertions.assertTrue(true);
         assertEquals("indexPage", driver.getTitle());
        driver.quit();
    }

    @Test
    public void testAddStudent() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        assertEquals("indexPage", driver.getTitle());
        WebElement addStudentButton = driver.findElement(By.id("addStudentButton"));
        addStudentButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("addStudentPage", driver.getTitle());
        driver.findElement(By.id("studentName")).sendKeys("TestName1");
        driver.findElement(By.id("studentLogin")).sendKeys("TestLogin1");
        driver.findElement(By.id("studentPassword")).sendKeys("TestPassword1");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        assertEquals("indexPage", driver.getTitle());
        Student student = instance.getStudentDAO().getById(1l);
        assertEquals("TestName1", student.getName());
        assertEquals("TestLogin1", student.getLogin());
        assertEquals("TestPassword1", student.getPassword());
        driver.quit();
    }

    @Test
    public void testAddTeacher() {
        Company company = new Company("company1", "addr1", null);
        instance.getCompanyDAO().add(company);
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        assertEquals("indexPage", driver.getTitle());
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        WebElement addStudentButton = driver.findElement(By.id("addTeacherButton"));
        addStudentButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("addTeacherPage", driver.getTitle());
        driver.findElement(By.id("teacherName")).sendKeys("TestName1");
        driver.findElement(By.id("teacherLogin")).sendKeys("TestLogin1");
        driver.findElement(By.id("teacherPassword")).sendKeys("TestPassword1");
        driver.findElement(By.id("companyId")).sendKeys("1");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertEquals("indexPage", driver.getTitle());
        Teacher teacher = instance.getTeacherDAO().getById(1l);
        assertEquals("TestName1", teacher.getName());
        assertEquals("TestLogin1", teacher.getLogin());
        assertEquals("TestPassword1", teacher.getPassword());
        assertEquals("company1", teacher.getCompany().getName());
        driver.quit();
    }

    @Test
    public void testCoursePage () {
        Course course = new Course("course1");
        instance.getCourseDAO().add(course);
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/courses");
        assertEquals("coursesPage", driver.getTitle());
        String text = driver.findElement(By.id("coursesList")).getText();
        driver.findElementById("toView").click();
        System.out.println(text);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("viewCoursePage", driver.getTitle());
        assertEquals("http://localhost:8080/viewCourse?id=1", driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void testTeacherToCourse () {
        Company company = new Company("company1", "addr1", null);
        instance.getCompanyDAO().add(company);
        Course course = new Course("course1");
        instance.getCourseDAO().add(course);
        Teacher teacher = new Teacher("teacher1", "log1", "pasw1", company, null);
        instance.getTeacherDAO().add(teacher);
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/viewCourse?id=1");
        assertEquals("viewCoursePage", driver.getTitle());
        driver.findElementById("addTeacherButton").click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("http://localhost:8080/teacherToCourse?course_id=1", driver.getCurrentUrl());
        driver.findElementById("teacherId").sendKeys("1");
        driver.findElementById("submitButton").click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("http://localhost:8080/viewCourse?id=1", driver.getCurrentUrl());
        assertEquals("1", driver.findElementById("teacherId").getText());
        assertEquals("teacher1", driver.findElementById("teacherName").getText());
        assertEquals("company1", driver.findElementById("companyName").getText());
        driver.quit();
    }

}
