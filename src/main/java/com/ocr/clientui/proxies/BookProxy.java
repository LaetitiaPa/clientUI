package com.ocr.clientui.proxies;


import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "library-api", url = "localhost:8088", configuration = FeignClientConfiguration.class)
public interface BookProxy {

    @RequestMapping(value = "/result", method = RequestMethod.GET)
     List<BookBean>searchBookByAuthorOrTitle ();

    @RequestMapping(value = "/books", method = RequestMethod.GET)
     List<BookBean> listBooks();

}
