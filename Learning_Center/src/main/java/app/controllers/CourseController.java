package app.controllers;

import app.dao.CourseClassDAO;
import app.dao.CourseDAO;
import app.dao.StudentDAO;
import app.dao.impl.CourseClassDAOImpl;
import app.dao.impl.CourseDAOImpl;
import app.dao.impl.StudentDAOImpl;
import app.models.Course;
import app.models.CourseClass;
import app.models.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class CourseController {

    private final CourseDAO courseDAO = new CourseDAOImpl();
    private final StudentDAO studentDAO = new StudentDAOImpl();
    private final CourseClassDAO courseClassDAO = new CourseClassDAOImpl();

    @GetMapping("/courses")
    public String courses(Model model) {
        Collection<Course> courses = courseDAO.getAll();
        model.addAttribute("courses", courses);
        model.addAttribute("new_course", new Course());
        model.addAttribute("courseDAO", courseDAO);
        return "courses";
    }

    @PostMapping(value = "/addCourse")
    public String addCoursePost(@ModelAttribute(name = "new_course") Course course, Model model) {
        courseDAO.add(course);
        return "redirect:/courses";
    }

    @GetMapping("/viewCourse")
    public String viewCourse(@RequestParam(name = "id") Integer id, Model model) {
        Course course = courseDAO.getById(id);
        List<Student> students = studentDAO.getByCourseId(new Long(id));
        model.addAttribute("course", course);
        model.addAttribute("courseDAO", courseDAO);
        model.addAttribute("students", students);
        return "viewCourse";
    }

    @GetMapping(value = "/classToCourse")
    public String studentToCourseGet(@RequestParam(name = "course_id") Integer course_id, Model model) {
        model.addAttribute("course_id", course_id);
        model.addAttribute("class", new CourseClass());
        return "classToCourse";
    }

    @PostMapping(value = "/classToCourse")
    public String studentToCoursePost(@ModelAttribute(name = "class") CourseClass courseClass,
                                      @RequestParam(name = "course_id") Integer course_id,
                                      RedirectAttributes redirectAttributes, Model model) {
        Course course = courseDAO.getById(course_id);
        courseClass.setCourse(course);
        Set<CourseClass> classes = course.getClasses();
        classes.add(courseClass);
        course.setClasses(classes);
        courseClassDAO.add(courseClass);
        courseDAO.update(course);
        redirectAttributes.addAttribute("id", course_id);
        return "redirect:/viewCourse";
    }
}










































