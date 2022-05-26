package app.controllers;

import app.dao.CompanyDAO;
import app.dao.CourseDAO;
import app.dao.TeacherDAO;
import app.models.Company;
import app.models.Course;
import app.models.Student;
import app.models.Teacher;
import app.util.DAOFactory;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Set;

import static jdk.nashorn.internal.runtime.Debug.id;

@Controller
public class TeacherController {

    private final TeacherDAO teacherDAO = DAOFactory.getInstance().getTeacherDAO();
    private final CourseDAO courseDAO = DAOFactory.getInstance().getCourseDAO();
    private final CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

    @GetMapping("/teachers")
    public String teachers(Model model) {
        Collection<Teacher> teachers = teacherDAO.getAll();
        model.addAttribute("teachers", teachers);
        model.addAttribute("new_teacher", new Teacher());
        model.addAttribute("teacherDAO", teacherDAO);
        return "teachers";
    }

    @GetMapping("/viewTeacher")
    public String viewTeacher(@RequestParam(name = "id") Long id, Model model) {
        Teacher teacher = teacherDAO.getById(id);
        Set<Course> courses = teacher.getCourses();
        model.addAttribute("teacher", teacher);
        model.addAttribute("company", teacher.getCompany());
        model.addAttribute("teacherDAO", teacherDAO);
        model.addAttribute("courses", courses);
        return "viewTeacher";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacherGet(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("company", new Company());
        return "addTeacher";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacherPost(@ModelAttribute(name = "teacher") Teacher teacher,
                                 @ModelAttribute(name = "company") Company company, Model model) {
        Company c = companyDAO.getById(company.getId());
        if (c == null)
            return "error";
        teacher.setCompany(c);
        teacherDAO.add(teacher);
        return "index";
    }

    @GetMapping(value="/teacherToCourse")
    public String teacherToCourseGet(@RequestParam(name="course_id") Integer course_id, Model model) {
        model.addAttribute("course_id", course_id);
        model.addAttribute("teacher", new Teacher());
        return "teacherToCourse";
    }

    @PostMapping(value = "/teacherToCourse")
    public String teacherToCoursePost(@ModelAttribute(name = "teacher") Teacher teacher,
                                      @RequestParam(name = "course_id") Integer course_id,
                                      RedirectAttributes redirectAttributes, Model model) {
        Course course = courseDAO.getById(course_id);
        Teacher tch = teacherDAO.getById(teacher.getId());
        Set<Teacher> teachers = course.getTeachers();
        teachers.add(tch);
        course.setTeachers(teachers);
        Set<Course> courses = tch.getCourses();
        courses.add(course);
        tch.setCourses(courses);
        teacherDAO.update(tch);
        courseDAO.update(course);
        redirectAttributes.addAttribute("id", course_id);
        return "redirect:/viewCourse";
    }

}