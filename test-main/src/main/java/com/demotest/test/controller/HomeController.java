package com.demotest.test.controller;

import com.demotest.test.model.City;
import com.demotest.test.model.State;
import com.demotest.test.service.ServiceDropword;
import com.demotest.test.service.StorageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Method;


@Controller
public class HomeController {

    @Autowired
    StorageService service;

    @Autowired
    ServiceDropword dropword;


    @RequestMapping("/")
    public String home(@ModelAttribute("dp")State st, Model model){

        model.addAttribute("states", dropword.findAllCity());

        return "index";
    }


//  @RequestMapping("/im")
//    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//        String uploadImage = service.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
//    @RequestMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//        byte[] imageData=service.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//
//    }


//    @RequestMapping("")
//    public String dropdwon(){
//        return "index";
//    }
}
