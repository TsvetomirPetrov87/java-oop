package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure{
    private Collection<Robot> robots;

    protected BaseProcedure(){
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder output = new StringBuilder();

        output.append(getClass().getSimpleName()).append(System.lineSeparator());
        robots.stream()
                .forEach(r -> output.append(r.toString()).append(System.lineSeparator()));

        return output.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if(robot.getProcedureTime() < procedureTime){
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }

        int newProcedureTime = robot.getProcedureTime() - procedureTime;
        robot.setProcedureTime(newProcedureTime);
        this.robots.add(robot);
    }
}
