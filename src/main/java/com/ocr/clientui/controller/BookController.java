package com.ocr.clientui.controller;

import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.proxies.BookProxy;
import feign.QueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookProxy bookProxy;

    @GetMapping ("/book/search-result")
    public List<BookBean> research(@QueryMap String title, @QueryMap String author ) {
        List<BookBean> research =  bookProxy.searchBookByAuthorOrTitle(title, author)  ;

        return research;
    }

}
