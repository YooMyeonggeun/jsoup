package com.example.jsoup.controller;


import com.example.jsoup.service.JsoupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Jsoupcontroller {

    private final JsoupService jsoupService;

    @GetMapping("/")
    public void Jsoupinsert() {
        jsoupService.jsoupservice();
    }

    @GetMapping("/test")
    public void test(){
        jsoupService.test();
    }

}
