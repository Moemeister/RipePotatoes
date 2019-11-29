package com.proyecto.ripepotatoes.resources;

import com.proyecto.ripepotatoes.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/allbooks")
public class BooksCatalogResource {
    @Value("${book.api.key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @GetMapping("")
    public ModelAndView getBookCatalog(){
        ModelAndView mav = new ModelAndView();
        BookWrapper bookWrapper= restTemplate.getForObject("https://api.nytimes.com/svc/books/v3/lists.json?list=hardcover-fiction&api-key="+apiKey, BookWrapper.class);
        List<BookResult> bookResultList=bookWrapper.getResults();
        ArrayList<BookDetail> bcatalog = new ArrayList<>();
        int i=0;
        String isbn="";
        while (i!=bookResultList.size()) {
            if(bookResultList.get(i).getBookDetails().get(0)!=null){
            bcatalog.add(bookResultList.get(i).getBookDetails().get(0));
            isbn=bookResultList.get(i).getBookDetails().get(0).getPrimary_isbn13();
            }
            i++;
        }
        mav.addObject("isbn",isbn);
        mav.addObject("bcatalog",bcatalog);
        mav.setViewName("home/bcatalog");
        return mav;
    }
}
