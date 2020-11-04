package com.manasia.curs2;

public class Mouse implements IAnimal {

    String animalName;

    public Mouse(String name){
        this.animalName = name;
    }
    @Override
    public String makeSound() {
        return "Click click!!";
    }

    @Override
    public String getGrooming() {
        return null;
    }
}
