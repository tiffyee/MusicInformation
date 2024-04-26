package com.expeditors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/pricing")
public class PricingServiceController {

    private int lowerLimit = 1;
    private int higherLimit = 7;

    @GetMapping("/{id}")
    public int getPriceForTrack(@PathVariable("id") int id){
        int price = ThreadLocalRandom.current().nextInt(lowerLimit, higherLimit);

        return price;
    }
}
