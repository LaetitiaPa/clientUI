package com.ocr.clientui.proxies;


import com.ocr.clientui.beans.BookBean;
import com.ocr.clientui.beans.CustomerBean;
import com.ocr.clientui.beans.Role;
import com.ocr.clientui.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "library-api", url = "localhost:8088", configuration = FeignClientConfiguration.class)
public interface BookProxy {

    @RequestMapping(value = "/book/search-result", method = RequestMethod.GET)
     List<BookBean> searchBookByAuthorOrTitle(@RequestParam String title, @RequestParam String author);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
     List<BookBean> listBooks();

/*
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    CustomerBean findCustomerById(@PathVariable Long id);*/

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    CustomerBean findCustomerById(@PathVariable Long id);

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    CustomerBean findCustomerByEmail( @RequestParam String email);

    @RequestMapping(value = "/customer/role", method = RequestMethod.GET)
    Role findCustomerRolesByEmail(@RequestParam String email);

}
