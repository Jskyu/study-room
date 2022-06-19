package ond.studyroom.controller;

import lombok.RequiredArgsConstructor;
import ond.studyroom.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;

    @GetMapping("/")
    public String test(){
        return service.test();
    }

    @GetMapping("/2")
    public String test2(){
        return service.test2();
    }

}