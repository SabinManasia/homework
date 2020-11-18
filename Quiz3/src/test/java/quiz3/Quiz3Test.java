package quiz3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "applicationContext.xml")
public class Quiz3Test {

    @Autowired
    CarFactory carFactory;


    @Test
    public void testIfElectric(){

        Car car = carFactory.createCar("electric");

        Assertions.assertEquals("LOW", car.getEngine().getPolutionCategory());
    }
}
