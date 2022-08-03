package com.ozerutkualtun.jackson.controller;

import com.ozerutkualtun.jackson.model.Bird;
import com.ozerutkualtun.jackson.service.BirdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/birds")
@RequiredArgsConstructor
public class BirdController {

    private final BirdService birdService;

    @GetMapping
    public String getBirdAsJson() {

        Bird bird = new Bird("Şakir", "{\"isFlying\":true}");
        return birdService.serializeBirdUsingJsonRawValue(bird);
    }

    /*
         {
            "name": "Şakir",
            "json": {
              "isFlying": true
            }
           }
     */
}
