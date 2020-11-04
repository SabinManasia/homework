package com.manasia.curs2;

public class Cat implements IAnimal {

    public static final String CATS_GET_GROOMED_AT = "cat service ";
    private GroomingService grooming;

    @Override
    public String makeSound() {
        return "Miau miau!!";
    }

    @Override
    public String getGrooming() {
        return grooming.getGrooming() + CATS_GET_GROOMED_AT;
    }

    public void setGrooming(GroomingService grooming) {
        this.grooming = grooming;
    }
}
