package quiz3;


public class ElectricMotor extends Motor {

    @Override
    public Motor.PolutionCategory getPolutionCategory() {
        return PolutionCategory.LOW;
    }
}
