package quiz3;

public class Car {

    private Motor engine;
    private String name;

    public Car(Motor engine, String name){
        this.engine = engine;
        this.name = name;
    }

    public Motor getEngine(){
        return this.engine;
    }
}
