package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    public static final int INITIAL_KILOGRAMS=7;
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

}
