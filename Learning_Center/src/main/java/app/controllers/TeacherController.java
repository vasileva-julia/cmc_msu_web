package app.controllers;

import app.dao.CourseDAO;
import app.dao.TeacherDAO;
import app.models.Course;
import app.models.Teacher;
import app.util.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
public class TeacherController {

    private final TeacherDAO teacherDAO = DAOFactory.getInstance().getTeacherDAO();
    private final CourseDAO courseDAO = DAOFactory.getInstance().getCourseDAO();

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addStudentGet(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "addTeacher";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addStudentPost(@ModelAttribute(name = "teacher") Teacher teacher, Model model) {
        teacherDAO.add(teacher);
        return "index";
    }

    @GetMapping(value="/teacherToCourse")
    public String ttcget(@RequestParam(name="course_id") Integer course_id, Model model) {
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