package com.ocr.clientui.controller;

import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.proxies.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
   private BookProxy bookProxy;

    @GetMapping("/")
    public String home(Model model) {

        List<BookBean> books =  bookProxy.listBooks();

        model.addAttribute("books", books);

        return "page-index-2";
    }




}
