package com.ocr.clientui.controller;

import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.proxies.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookProxy bookProxy;

    @GetMapping("/result")
    public String research(Model model) {

        List<BookBean> result =  bookProxy.searchBookByAuthorOrTitle();

        model.addAttribute("result", result);

        return "test";
    }

}
