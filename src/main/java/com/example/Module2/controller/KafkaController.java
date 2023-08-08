package com.example.Module2.controller;


import com.example.Module2.model.UserStockPreference;
import com.example.Module2.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class KafkaController {
    @Autowired
    KafkaProducer mps;

    @GetMapping("/send")
   // @PreAuthorize("isAuthenticated()")
    public String publishMessage(@RequestBody UserStockPreference message ){
      //  String jwtToken=autho.substring(7);
        mps.sendMessage(message);
        return "Data Published";
    }
}