package com.quiz4.Quiz4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SumController {

    @RequestMapping(value = "/add/first/{first}/second/{second}")
    public String sum(@PathVariable int first, @PathVariable int second){
        int sum = first + second;
        return sum + "";
    }
}
