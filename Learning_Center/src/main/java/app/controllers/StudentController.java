package app.controllers;

import app.dao.CourseDAO;
import app.dao.StudentDAO;
import app.models.Course;
import app.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.util.DAOFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getStudentDAO();
    private final CourseDAO courseDAO = DAOFactory.getInstance().getCourseDAO();

    @GetMapping("/students")
    public String students(Model model) {
        Collection<Student> students = studentDAO.getAll();
        model.addAttribute("students", students);
        model.addAttribute("new_student", new Student());
        model.addAttribute("studentDAO", studentDAO);
        return "students";
    }

    @GetMapping("/viewStudent")
    public String viewStudent(@RequestParam(name = "id") Long id, Model model) {
        Student student = studentDAO.getById(id);
        Set<Course> courses = student.getCourses();
        model.addAttribute("student", student);
        model.addAttribute("studentDAO", studentDAO);
        model.addAttribute("courses", courses);
        return "viewStudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentGet(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudentPost(@ModelAttribute(name = "student") Student student, Model model) {
//        student.setCourses(new HashSet<>(0));
        studentDAO.add(student);
        return "index";
    }

    @GetMapping(value = "/studentToCourse")
    public String studentToCourseGet(@RequestParam(name = "course_id") Integer course_id, Model model) {
//        Course course = courseDAO.getById(course_id);
        model.addAttribute("course_id", course_id);
        model.addAttribute("student", new Student());
        return "studentToCourse";
    }

    @PostMapping(value = "/studentToCourse")
    public String studentToCoursePost(@ModelAttribute(name = "student") Student student,
                                      @RequestParam(name = "course_id") Integer course_id,
                                      RedirectAttributes redirectAttributes, Model model) {
        Course course = courseDAO.getById(course_id);
        Student st = studentDAO.getById(student.getId());
        Set<Student> students = course.getStudents();
        students.add(st);
        course.setStudents(students);
        Set<Course> courses = st.getCourses();
        courses.add(course);
        st.setCourses(courses);
        studentDAO.update(st);
        courseDAO.update(course);
        redirectAttributes.addAttribute("id", course_id);
        return "redirect:/viewCourse";
    }

}