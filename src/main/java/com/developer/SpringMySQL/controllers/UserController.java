/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.models.Role;
import com.developer.SpringMySQL.models.User;
import com.developer.SpringMySQL.repository.RoleRepository;
import com.developer.SpringMySQL.repository.UserRepository;
import com.developer.SpringMySQL.tools.BCrypt;
import com.developer.SpringMySQL.tools.HtmlSendMail;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ObjectFactory;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

//    HttpSession session;
//    @RequestMapping("/")
//    public ModelAndView index() {
//        ModelAndView mv = new ModelAndView("index");
//        return mv;
//    }
    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * untuk tampilkan view register
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("/register");
        return mv;
    }
    @RequestMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("adminIndex");
        return mv;
    }

//    @RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("lists",appRepo.findAll());
//        return "index";
//    }
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView doRegister(@RequestParam("id") String id, @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("password1") String password1, @RequestParam("email") String email) {

        User account = userRepository.getByName(username); //cari Id by username
        ModelAndView mv = new ModelAndView();
        if (account != null) { //cek username
            mv.addObject("flash", "Failed");
            mv.addObject("message", "username");
            mv = new ModelAndView("redirect:/register");
        } else {
            if (password.equals(password1)) { //cek password
                mv.addObject("flash", "Registered");
                userRepository.save(new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), email, 0, new Role(3)));
//                ambil id yang didaftarkan berdasarkan username
//                UserAccount userAccount = (UserAccount) dao.selectByField("UserAccount", "username", username);
                new HtmlSendMail().send(email, username);
                mv = new ModelAndView("redirect:/");
//            response.sendRedirect("loginView.jsp");
            } else {
                mv.addObject("flash", "Failed");
                mv.addObject("message", "username");
                mv = new ModelAndView("redirect:/register");
            }
        }
        return mv;
//        User user;
//        if (!id.isEmpty()) {
//            user = (User) userRepository.findOne(Integer.parseInt(id));
//        } else {
//            user = new User();
//        }
//
//        new HtmlSendMail().send(email, username);
//        mv.addObject("flash", "Success");

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepository.getByName(username); //cari Id by username
        ModelAndView mv = new ModelAndView();
//        cek user sudahterdaftar ?
        if (user != null) {
//            cek akun aktif?
            if (user.getStatus() == 1) {
//                cek password
                if (BCrypt.checkpw(password, user.getPassword())) {
                    mv = new ModelAndView("adminIndex");
//                    session.setAttribute("id", Integer.toString(user.getId()));
                    mv.addObject("id", Integer.toString(user.getId()));
                } else { //password salah
                    mv = new ModelAndView("redirect:/");
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
        //        user = (User) userRepository.findOne(Integer.parseInt(id.getUsername().toString()));
        User user;
        User id = userRepository.getByName(username); //cari Id by username
        User product = userRepository.findOne(id.getId());
        product.setStatus(1);
        userRepository.save(product);
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
