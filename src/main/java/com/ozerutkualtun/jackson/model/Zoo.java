package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Zoo {

    public Animal animal;

    @JsonCreator
    public Zoo(Animal animal) {
        this.animal = animal;
    }


    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    @AllArgsConstructor
    public static class Animal {
        public String name;
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name, Double barkVolume) {
            super(name);
            this.barkVolume = barkVolume;
        }

    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name,Boolean likesCream, Integer lives) {
            super(name);
            this.likesCream = likesCream;
            this.lives = lives;
        }
    }
}