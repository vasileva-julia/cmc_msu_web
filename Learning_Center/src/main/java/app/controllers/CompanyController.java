package app.controllers;

import app.dao.CompanyDAO;
import app.dao.CourseDAO;
import app.models.Company;
import app.models.Student;
import app.util.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class CompanyController {

    private final CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

    @GetMapping("/companies")
    public String companies(Model model) {
        Collection<Company> companies = companyDAO.getAll();
        model.addAttribute("companies", companies);
        model.addAttribute("new_company", new Company());
        model.addAttribute("companyDAO", companyDAO);
        return "companies";
    }

    @GetMapping(value = "/addCompany")
    public String addStudentGet(Model model) {
        model.addAttribute("company", new Company());
        return "addCompany";
    }

    @PostMapping(value = "/addCompany")
    public String addStudentPost(@ModelAttribute(name = "company") Company company, Model model) {
        companyDAO.add(company);
        return "index";
    }
}
