package com.quiz4.Quiz4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SumController {

    //@RequestMapping(value = "/add/first/{first}/second/{second}", method = RequestMethod.GET)
    @GetMapping("/add/first/{first}/second/{second}")
    @ResponseBody
    public String sum(@PathVariable int first, @PathVariable int second){
        int sum = first + second;
        String result = sum + "";
        return result;
    }
}
