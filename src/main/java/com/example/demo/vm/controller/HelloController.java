package com.example.demo.vm.controller;

import com.example.demo.vm.vo.BookVo;
import com.example.demo.vm.vo.DefaultBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private DefaultBook defaultBook;

   @GetMapping("/books")
    public ModelAndView helloJsp(){
        List<BookVo> bookList = new ArrayList<>();
        BookVo b1 = new BookVo();
        b1.setId(1);
        b1.setName(defaultBook.getName());
        b1.setAuthor(defaultBook.getAuthor());
        BookVo b2 = new BookVo();
        b2.setId(2);
        b2.setName("三国演义");
        b2.setAuthor("罗贯中");
        bookList.add(b1);
        bookList.add(b2);
        ModelAndView view = new ModelAndView();
        view.addObject("books",bookList);
        view.setViewName("book");
        return view;
    }
    @ResponseBody
    @GetMapping("/mocTest")
    public String mocMvcTest() {
        return "sss";
    }
}
