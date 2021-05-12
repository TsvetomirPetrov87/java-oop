package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {

    public Work() {
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);

        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() - 6);
    }
}
