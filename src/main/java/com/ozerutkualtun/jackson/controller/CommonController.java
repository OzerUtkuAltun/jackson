package com.ozerutkualtun.jackson.controller;

import com.ozerutkualtun.jackson.model.*;
import com.ozerutkualtun.jackson.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/common")
@RequiredArgsConstructor
public class CommonController {

    private final CommonService commonService;

    @GetMapping("/types")
    public String getTypeAsJson() {

        return commonService.serializeTypeEnumWithValueUsingJsonValue(TypeEnum.TYPE1);
    }

    User user = new User(1, "Utku");

    @GetMapping("/users")
    public String getUsersAsJson() {
        return commonService.serializeUserUsingJsonRootName(user);
    }

    @GetMapping("/events")
    public String getEventAsJson() {

        return commonService.serializeEventWithDateSerializerUsingJsonSerialize();
    }

    @PostMapping("/events")
    public EventWithSerializer deserializeToEvent() {

        String json
                = "{\"e_name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        return commonService.deserializeEventWithDateSerializerUsingJsonDeserialize(json);
    }


    @PostMapping("/users")
    public User deserializeToUser() {

        return commonService.deserializeUserUsingJacksonInject();
    }

    @PostMapping("/waters")
    public Water deserializeToWater() {

        String json = "{\"id\":17,\"waterName\":\"Saka Su\"}";
        return commonService.deserializeWaterUsingJsonSetter(json);
    }

    @GetMapping("/houses")
    public String serializeHouse() {

        Map<String, String> location = new HashMap<>();
        location.put("city", "Istanbul");
        location.put("street", "Cherry Street");

        House house = new House(1, location, null, null, new House.Owner("f_name", "l_name"));

        return commonService.serializeHouse(house);
    }

    @GetMapping("/zoo/dogs")
    public String serializeZooWithDog() {
        return commonService.serializeZooWithDog();
    }


    @GetMapping("/zoo/cats")
    public String serializeZooWithCat() {
        return commonService.serializeZooWithCat();
    }

    @PostMapping("zoo")
    public Zoo deserializeZoo() {
        return commonService.deserializeZoo();
    }

}
