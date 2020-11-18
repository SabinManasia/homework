package quiz3;

public abstract class Motor {

    private int hP;
    public enum PolutionCategory {
        LOW, MEDIUM, HIGH
    }

    public abstract PolutionCategory getPolutionCategory();

}
