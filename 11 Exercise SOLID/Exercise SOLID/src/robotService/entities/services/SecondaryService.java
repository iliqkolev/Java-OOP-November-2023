package robotService.entities.services;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.Robot;

public class SecondaryService extends BaseService {
    public static final int CAPACITY = 15;

    public SecondaryService(String name) {
        super(name, CAPACITY);
    }

}
