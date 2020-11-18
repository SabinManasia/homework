package quiz3;

import org.springframework.stereotype.Component;

@Component
public class MotorFactory {


    public Motor produceMotor(String type) throws Exception {
        if(type.equalsIgnoreCase("electric")){
            return new ElectricMotor();
        }
        if(type.equalsIgnoreCase("petrol")) {
            return new PetrolMotor();
        }
        if(type.equalsIgnoreCase("diesel")){
            return new DieselMotor();
        }
        throw new Exception("Type: " + type + " is non Existent");
    }
}
