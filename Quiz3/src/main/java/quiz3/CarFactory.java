package quiz3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarFactory {

    private MotorFactory motorFactory;

    @Autowired
    public CarFactory(MotorFactory motorFactory){
        this.motorFactory = motorFactory;
    }

    public Car createCar(String type){
        try{
            return new Car(this.motorFactory.produceMotor(type), "Trabant");
        } catch (Exception e){
            System.out.println("wrong engine type!!!");
            e.printStackTrace();
        }
        return null;
    }
}
