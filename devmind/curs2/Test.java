package com.manasia.curs2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAnimal animal = context.getBean("myAnimal", IAnimal.class);
        IAnimal mouse = context.getBean("animalName", IAnimal.class);
        IAnimal cat = context.getBean("catAnimal", IAnimal.class);

        System.out.println(animal.getGrooming());
        System.out.println(mouse.makeSound());
        System.out.println(cat.getGrooming());


    }
}
