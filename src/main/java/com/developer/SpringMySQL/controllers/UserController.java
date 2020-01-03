/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.models.RowAccess;
import com.developer.SpringMySQL.models.User;
import com.developer.SpringMySQL.repository.RoleRepository;
import com.developer.SpringMySQL.repository.RowAccessRepository;
import com.developer.SpringMySQL.repository.UserRepository;
import com.developer.SpringMySQL.repository.VacancyRepository;
import com.developer.SpringMySQL.tools.BCrypt;
import com.developer.SpringMySQL.tools.HtmlSendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RowAccessRepository rowAccessRepository;

    @Autowired
    private VacancyRepository vacancyRepository;
//    HttpSession session;
//    @RequestMapping("/")
//    public ModelAndView index() {
//        ModelAndView mv = new ModelAndView("index");
//        return mv;
//    }

    /**
     * view login frontend
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("frontend_login");
        return mv;
    }

    /**
     * view login backend
     *
     * @return
     */
    @RequestMapping("/employee")
    public ModelAndView loginBackend() {
        ModelAndView mv = new ModelAndView("login_backend");
        mv.addObject("lists", roleRepository.getAllRoleBackend("3"));
        return mv;
    }

    /**
     * untuk tampilkan view register
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("/frontend_register");
        return mv;
    }

    @RequestMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("adminIndex");
        return mv;
    }

    @RequestMapping("/candidateform")
    public ModelAndView candidate_form() {
        ModelAndView mv = new ModelAndView("frontend_candidate_main");
        return mv;
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView doRegister(@RequestParam("id") String id, @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("password1") String password1, @RequestParam("email") String email) {

        User account = userRepository.getByName(username); //cari Id by username
        ModelAndView mv = new ModelAndView();
        if (account != null) { //cek username
            mv.addObject("flash", "Failed");
            mv.addObject("message", "username");
            mv = new ModelAndView("redirect:/frontend_register");
        } else {
            if (password.equals(password1)) { //cek password
                mv.addObject("flash", "Registered");
                userRepository.save(new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), email, 0));
//                ambil id yang didaftarkan berdasarkan username
                new HtmlSendMail().send(email, username);
                mv = new ModelAndView("redirect:/");
//            response.sendRedirect("loginView.jsp");
            } else {
                mv.addObject("flash", "Failed");
                mv.addObject("message", "username");
                mv = new ModelAndView("redirect:/frontend_register");
            }
        }
        return mv;
    }

    /**
     * login khusus backend : admin, HR , Employee
     *
     * @param username
     * @param password
     * @param role
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView actionLoginBackEnd(@RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("role") int role) {
        User user = userRepository.getByName(username); //cari Id by username
        ModelAndView mv = new ModelAndView();
//        cek user sudahterdaftar ?
        if (user != null) {
//            cek akun aktif?
            if (user.getStatus() == 1) {
//                cek password
                if (BCrypt.checkpw(password, user.getPassword())) {
//                    cek role
                    RowAccess rowAccess = rowAccessRepository.getUserRole(user.getId().toString(), role); //dapat role user
                    if (rowAccess != null) { //cek di tbl row access apakah ada user nya
                        if (rowAccess.getRole() == 1) { //if admin
                            mv = new ModelAndView("adminIndex");
//                    session.setAttribute("id", Integer.toString(user.getId()));
                            mv.addObject("id", Integer.toString(user.getId()));
                        } else if (rowAccess.getRole() == 2) { //if HR
                            mv = new ModelAndView("hr_vacancyview");
                            mv.addObject("listVacancy", vacancyRepository.findAll());
                            mv.addObject("id", Integer.toString(user.getId()));
                        } else if (rowAccess.getRole() == 4) { //if Accountant
                            mv = new ModelAndView("accountantIndex");
//                    session.setAttribute("id", Integer.toString(user.getId()));
                            mv.addObject("id", Integer.toString(user.getId()));
                        } else {
                            mv = new ModelAndView("redirect:/employee");
                            mv.addObject("flash", "You don't have access to this role");
                        }
                    } else {
                        mv = new ModelAndView("redirect:/employee");
                        mv.addObject("flash", "You don't have access to this role");
                    }

                } else { //password salah
                    mv = new ModelAndView("redirect:/employee");
                    mv.addObject("flash", "Password");
                }
            } else { // akun blm aktif
                mv = new ModelAndView("redirect:/employee");
                mv.addObject("flash", "Activated");
            }
        } else { //user blm terdaftar
            mv = new ModelAndView("redirect:/employee");
            mv.addObject("flash", "Register");
        }
        return mv;
    }

    /**
     * login frontend : Candidate
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepository.getByName(username); //cari Id by username
        ModelAndView mv = new ModelAndView();
//        cek user sudahterdaftar ?
        if (user != null) {
//            cek akun aktif?
            if (user.getStatus() == 1) {
//                cek password
                if (BCrypt.checkpw(password, user.getPassword())) {
//                    mv = new ModelAndView("frontend_candidate_main");
//                    mv = new ModelAndView("redirect:/career");
                    mv = new ModelAndView("frontend_vacancy");
//                    session.setAttribute("id", Integer.toString(user.getId()));
                    mv.addObject("vacancy", vacancyRepository.findAll());
                    mv.addObject("user", user);
                } else { //password salah

                    mv.addObject("flash", "Password");
                }
            } else { // akun blm aktif
                mv = new ModelAndView("redirect:/");
                mv.addObject("flash", "Activated");
            }
        } else { //user blm terdaftar
            mv = new ModelAndView("redirect:/");
            mv.addObject("flash", "Register");
        }
        return mv;
    }

    @RequestMapping(value = "/user/verification/{username}", method = RequestMethod.GET)
    public ModelAndView verification(@PathVariable("username") String username) {
        ModelAndView mv = new ModelAndView("redirect:/");
//            User user = (User) userRepository.findOne(Integer.parseInt(id.getUsername().toString()));
        User user;
        Integer id = userRepository.getByName(username).getId(); //get Id by username
        User product = userRepository.findOne(id);
        product.setStatus(1);
        userRepository.save(product);

        rowAccessRepository.save(new RowAccess(id, 3));
        mv.addObject("flash", "Success");
        return mv;
    }

//    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
//    public ModelAndView doView(@PathVariable("id") int id){
//        ModelAndView mv = new ModelAndView("view");
//        mv.addObject("lists",appRepo.findOne(id));
//        return mv;
//    }
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("redirect:/");
        userRepository.delete(id);
        return mv;
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists", userRepository.findOne(id));
        return mv;
    }
}
