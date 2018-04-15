package com.cai.utils.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value="hi")
    public String hi(){
        return "I am : " + serverPort;
    }


    @RequestMapping(value="hi", method = RequestMethod.POST)
    public String hi2(String param1){
        return "post-hi-" + param1;
    }

}
