package com.ozerutkualtun.jackson.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ozerutkualtun.jackson.model.*;
import com.ozerutkualtun.jackson.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final ObjectMapper objectMapper;

    @Override
    public String serializeTypeEnumWithValueUsingJsonValue(TypeEnum typeEnum) {

        try {
            return objectMapper.writeValueAsString(typeEnum);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String serializeUserUsingJsonRootName(User user) {

        try {
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        /*
        RESPONSE

        {
         "users": {
           "id": 1,
           "name": "Utku"
                   }
        }
         */

    }

    @Override
    public String serializeEventWithDateSerializerUsingJsonSerialize() {

        SimpleDateFormat dateFormat
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String toParse = "03-08-2022 02:30:00";
        Date date = null;
        try {
            date = dateFormat.parse(toParse);
            EventWithSerializer event = new EventWithSerializer("party", date);
            return objectMapper.writeValueAsString(event);

        } catch (ParseException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User deserializeUserUsingJacksonInject() {

        String json = "{\"name\":\"Özer Utku Altun\"}";
        InjectableValues inject = new InjectableValues.Std()
                .addValue(Integer.class, 174);

        User user = null;
        try {
            user = objectMapper.reader(inject).forType(User.class).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Water deserializeWaterUsingJsonSetter(String json) {

        Water water = null;
        try {
            water = objectMapper.readerFor(Water.class).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return water;
    }

    @Override
    public EventWithSerializer deserializeEventWithDateSerializerUsingJsonDeserialize(String json) {

        EventWithSerializer event = null;

        try {
            event = new ObjectMapper()
                    .readerFor(EventWithSerializer.class)
                    .readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public String serializeHouse(House house) {

        try {
            return objectMapper.writeValueAsString(house);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String serializeZooWithDog() {

        Zoo.Dog dog = new Zoo.Dog("Patik", 37.3);
        Zoo zoo = new Zoo(dog);

        try {
            return objectMapper.writeValueAsString(zoo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        /*
        OUTPUT
        {
          "animal": {
            "type": "dog",
            "name": "Patik",
            "barkVolume": 37.3
          }
        }

         */
    }

    @Override
    public String serializeZooWithCat() {

        Zoo.Cat cat = new Zoo.Cat("Fındık", true, 9);
        Zoo zoo = new Zoo(cat);

        try {
            return objectMapper.writeValueAsString(zoo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        /*
        OUTPUT: (Not: type field'ı @JsonTypeName("cat") kısmından geliyor)

        {
              "animal": {
                "type": "cat",
                "name": "Fındık",
                "lives": 9
              }
        }

         */

    }

    @Override
    public Zoo deserializeZoo() {

        String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\", \"likesCream\": true, \"lives\": 9}}";

        try {
            return objectMapper.readerFor(Zoo.class).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
