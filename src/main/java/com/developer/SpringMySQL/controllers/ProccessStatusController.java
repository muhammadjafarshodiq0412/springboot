/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.models.Candidate;
import com.developer.SpringMySQL.models.Company;
import com.developer.SpringMySQL.models.Jobs;
import com.developer.SpringMySQL.models.ProcessStatus;
import com.developer.SpringMySQL.models.User;
import com.developer.SpringMySQL.models.Vacancy;
import com.developer.SpringMySQL.repository.CandidateRepository;
import com.developer.SpringMySQL.repository.CompanyRepository;
import com.developer.SpringMySQL.repository.JobRepository;
import com.developer.SpringMySQL.repository.ProccessStatusRepository;
import com.developer.SpringMySQL.repository.UserRepository;
//import com.developer.SpringMySQL.repository.ProccessStatusRepository;
import com.developer.SpringMySQL.repository.VacancyRepository;
import com.developer.SpringMySQL.tools.HtmlSendMail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
public class ProccessStatusController {

    @Autowired
    private ProccessStatusRepository proccessStatusRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;

//    @RequestMapping("/beranda")
//    public ModelAndView proccessstatus() {
//        ModelAndView mv = new ModelAndView("beranda");
//        mv.addObject("listJob", jobRepository.findAll());
//        mv.addObject("listCompany", companyRepository.findAll());
//        return mv;
//    }
//
//    @RequestMapping("/vacancyview")
//    public ModelAndView vacancyView() {
//        ModelAndView mv = new ModelAndView("vacancyview");
//        mv.addObject("listVacancy", vacancyRepository.findAll());
//        return mv;
//    }
//
//    @RequestMapping(value = "/vacancy/save", method = RequestMethod.POST)
//    public ModelAndView doSaveVacancy(@RequestParam("id") String id, @RequestParam("job") String job,
//            @RequestParam("company") String company, @RequestParam("descrip") String descrip,
//            @RequestParam("status") String status, @RequestParam("expired") String expired)
//            throws ParseException {
//
//        String startDate = expired;
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date date = sdf1.parse(startDate);
//        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//        ModelAndView mv = new ModelAndView("redirect:/vacancyview");
//        Vacancy vacancy;
//
//        if (!id.isEmpty()) {
//            vacancy = (Vacancy) vacancyRepository.findOne(Integer.parseInt(id));
//        } else {
//            vacancy = new Vacancy();
//        }
//        vacancy.setJobs(new Jobs(Integer.parseInt(job)));
//        vacancy.setCompany(new Company(Integer.parseInt(company)));
//        vacancy.setDescription(descrip);
//        vacancy.setStatus(Integer.parseInt(status));
//        vacancy.setExpired(sqlStartDate);
//        vacancyRepository.save(vacancy);
//
//        return mv;
//    }
//    
    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public ModelAndView apply(@RequestParam("user") String userId,
            @RequestParam("vacancy") String vacancy) {

        User user = userRepository.findOne(Integer.parseInt(userId));
        Candidate candidate = candidateRepository.getByUser(userId);

        ModelAndView mv = new ModelAndView("frontend_vacancy");
        mv.addObject("vacancy", vacancyRepository.findAll());
        mv.addObject("user", user);
        proccessStatusRepository.save(new ProcessStatus(2, candidate.getId(), Integer.parseInt(vacancy)));
        return mv;
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    public ModelAndView approve(@RequestParam("id") String processId) {
        //get ProcessStatus
        ProcessStatus processStatus = proccessStatusRepository.findOne(Integer.parseInt(processId));
        //get Candidate
        Candidate candidate = candidateRepository.findOne(processStatus.getCandidate());
        //get Job by vacancy
        Vacancy vacancy = (Vacancy) vacancyRepository.findOne(processStatus.getVacancy());
        //get Job
        Jobs jobs = jobRepository.findOne(vacancy.getJobs().getId());
        //send Notification 
        new HtmlSendMail().sendNotification(candidate.getEmail(), candidate.getFirstName(), jobs.getJobTitle(),
                "Congratulation!! your status has been approved on this job \n"
                + "we will contact you by phone \n"
                + "Thank You");
        ModelAndView mv = new ModelAndView("hr_process_status");
        mv.addObject("process_status", proccessStatusRepository.findAll());
        //update Status jadi 3
        processStatus.setStatus(3);
        proccessStatusRepository.save(processStatus);
        return mv;
    }

    @RequestMapping(value = "/statusApply")
    public ModelAndView statusApply() {

//        User user = userRepository.findOne(Integer.parseInt(userId));
//        Candidate candidate = candidateRepository.getByUser(userId);
//        List<ProcessStatus> l = proccessStatusRepository.getProcessStatus();
        ModelAndView mv = new ModelAndView("hr_process_status");
        mv.addObject("process_status", proccessStatusRepository.findAll());
        return mv;
    }
//
//    @RequestMapping(value = "/deleteVacancy/{id}", method = RequestMethod.GET)
//    public ModelAndView doDeleteVacancy(@PathVariable("id") int id) {
//        ModelAndView mv = new ModelAndView("redirect:/vacancyview");
//        vacancyRepository.delete(id);
//        return mv;
//    }
//    @RequestMapping(value = "/deleteVacancy/{id}", method = RequestMethod.GET)
//    public ModelAndView doDeleteVacancy(@PathVariable("id") int id) {
//        ModelAndView mv = new ModelAndView("redirect:/vacancyview");
//        vacancyRepository.delete(id);
//        return mv;
//    }

}
