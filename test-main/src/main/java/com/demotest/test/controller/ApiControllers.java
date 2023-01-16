package com.demotest.test.controller;

import com.demotest.test.service.ServiceDropword;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @Autowired
    ServiceDropword dropword;



    @RequestMapping(value = "citys/{id}")
    public String getCityById(@PathVariable("id") Integer id, Model model){
        Gson gson = new Gson();
        return gson.toJson(dropword.findCityById(id));
    }

}
