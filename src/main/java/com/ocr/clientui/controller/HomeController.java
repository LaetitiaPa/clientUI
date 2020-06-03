package com.ocr.clientui.controller;

import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.beans.CustomerBean;
import com.ocr.clientui.beans.Role;
import com.ocr.clientui.proxies.BookProxy;
import feign.QueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
   private BookProxy bookProxy;

    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView mv = new ModelAndView();
        List<BookBean> books =  bookProxy.listBooks();
        model.addAttribute("books", books);
        mv.setViewName("page-index-2");

        return mv;
    }

    @GetMapping("/customer/{id}")
    public CustomerBean customer(@PathVariable("id") Long id) {
       CustomerBean customer;
       customer = bookProxy.findCustomerById(id);

        return customer;
    }

    @GetMapping("/customer")
    public CustomerBean customerByEmail(@QueryMap String email) {
        CustomerBean customer;
        customer = bookProxy.findCustomerByEmail(email);

        return customer;
    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");

        return mv;
    }




}
