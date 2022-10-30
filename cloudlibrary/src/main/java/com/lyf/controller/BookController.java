package com.lyf.controller;

import com.lyf.service.BookService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/selectNewbooks")
    public ModelAndView selectNewbooks(){
        int pageNum = 1;
        int pageSize = 5;
        PageResult pageResult = bookService.selectNewBooks(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books_new.jsp");
        modelAndView.addObject("pageResult", pageResult);
        return modelAndView;

    }
}
