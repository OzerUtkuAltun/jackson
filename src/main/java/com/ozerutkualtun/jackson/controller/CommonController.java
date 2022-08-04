package com.ozerutkualtun.jackson.controller;

import com.ozerutkualtun.jackson.model.TypeEnum;
import com.ozerutkualtun.jackson.model.User;
import com.ozerutkualtun.jackson.model.Water;
import com.ozerutkualtun.jackson.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/commons")
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

    @PostMapping("/users")
    public User deserializeToUser() {

        return commonService.deserializeUserUsingJacksonInject();
    }

    @PostMapping("/waters")
    public Water deserializeToWater() {

        String json = "{\"id\":17,\"waterName\":\"Saka Su\"}";
        return commonService.deserializeWaterUsingJsonSetter(json);
    }
}
