package com.manasia.curs2;

public class Dog implements IAnimal {

    private GroomingService grooming;

    public Dog(GroomingService grooming){
        this.grooming = grooming;
    }

    @Override
    public String makeSound() {
        return "Byork Byork!";
    }

    @Override
    public String getGrooming() {
        return grooming.getGrooming() + "dog service";
    }

}
