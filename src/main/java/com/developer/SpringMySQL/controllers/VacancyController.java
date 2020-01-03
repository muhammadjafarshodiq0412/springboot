/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.models.Company;
import com.developer.SpringMySQL.models.Jobs;
import com.developer.SpringMySQL.models.Vacancy;
import com.developer.SpringMySQL.repository.CompanyRepository;
import com.developer.SpringMySQL.repository.JobRepository;
import com.developer.SpringMySQL.repository.VacancyRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class VacancyController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private VacancyRepository vacancyRepository;

    /**
     * load view vcancy career
     *
     * @return
     */
    @RequestMapping("/career")
    public ModelAndView career() {
        ModelAndView mc = new ModelAndView("frontend_vacancy");
        mc.addObject("vacancy", vacancyRepository.findAll());
        return mc;
    }

    @RequestMapping("/vacancyadd")
    public ModelAndView vacancy() {
        ModelAndView mv = new ModelAndView("hr_vacancyadd");
        mv.addObject("listJob", jobRepository.findAll());
        mv.addObject("listCompany", companyRepository.findAll());
        mv.addObject("flash", "Save");
        return mv;
    }

//    @RequestMapping("/vacancy")
//    public ModelAndView vacancy() {
//        ModelAndView mv = new ModelAndView("hr_vacancy");
//        mv.addObject("listJob", jobRepository.findAll());
//        mv.addObject("listCompany", companyRepository.findAll());
////        mv.addObject("update", vacancyRepository.findOne(id));
//        return mv;
//    }
    @RequestMapping("/vacancyview")
    public ModelAndView vacancyView() {
        ModelAndView mv = new ModelAndView("hr_vacancyview");
        mv.addObject("listJob", jobRepository.findAll());
        mv.addObject("listCompany", companyRepository.findAll());
        mv.addObject("listVacancy", vacancyRepository.findAll());
        return mv;
    }

//    @RequestMapping("/vacancyview")
//    public ModelAndView vacancyView() {
//        ModelAndView mv = new ModelAndView("hr_vacancyview");
//        mv.addObject("listVacancy", vacancyRepository.findAll());
//        return mv;
//    }
    @RequestMapping(value = "/vacancy/save", method = RequestMethod.POST)
    public ModelAndView doSaveVacancy(@RequestParam("id") String id, @RequestParam("job") String job,
            @RequestParam("company") String company, @RequestParam("descrip") String descrip,
            @RequestParam("status") String status, @RequestParam("expired") String expired)
            throws ParseException {

        String startDate = expired;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        ModelAndView mv = new ModelAndView("redirect:/vacancyview");
        Vacancy vacancy;

        if (!id.isEmpty()) {
            vacancy = (Vacancy) vacancyRepository.findOne(Integer.parseInt(id));
        } else {
            vacancy = new Vacancy();
        }
        vacancy.setJobs(new Jobs(Integer.parseInt(job)));
        vacancy.setCompany(new Company(Integer.parseInt(company)));
        vacancy.setDescription(descrip);
        vacancy.setStatus(Integer.parseInt(status));
        vacancy.setExpired(sqlStartDate);
        vacancyRepository.save(vacancy);
        mv.addObject("flash", "Save");
//        mv.addObject("flash", "Save");
        return mv;
    }

    @RequestMapping(value = "/updateVacancy", method = RequestMethod.GET)
    public ModelAndView doFormEditVacancy(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView("hr_vacancyedit");
        mv.addObject("listJob", jobRepository.findAll());
        mv.addObject("listCompany", companyRepository.findAll());
        mv.addObject("update", vacancyRepository.findOne(id));
        return mv;
    }

    @RequestMapping(value = "/deleteVacancy/{id}", method = RequestMethod.GET)
    public ModelAndView doDeleteVacancy(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("redirect:/vacancyview");
        vacancyRepository.delete(id);
        return mv;
    }

}
