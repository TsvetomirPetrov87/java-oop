package robotService.core.interfaces;

import robotService.models.garages.interfaces.Garage;
import robotService.models.garages.interfaces.GarageImpl;
import robotService.models.procedures.interfaces.Charge;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.procedures.interfaces.Repair;
import robotService.models.procedures.interfaces.Work;
import robotService.models.robots.interfaces.Cleaner;
import robotService.models.robots.interfaces.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.repair = new Repair();
        this.charge = new Charge();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {

        Robot robot;

        if(robotType.equals("Housekeeper")){
            robot = new Housekeeper(name, energy, happiness, procedureTime);
        } else if(robotType.equals("Cleaner")){
            robot = new Cleaner(name, energy, happiness, procedureTime);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, name));
        }

        this.garage.manufacture(robot);

        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {

        checkIfRobotExist(robotName);

        this.repair.doService(this.garage.getRobots().get(robotName), procedureTime);

        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {

        checkIfRobotExist(robotName);

        this.work.doService(this.garage.getRobots().get(robotName), procedureTime);

        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {

        checkIfRobotExist(robotName);

        this.charge.doService(this.garage.getRobots().get(robotName), procedureTime);

        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {

        checkIfRobotExist(robotName);

        this.garage.sell(robotName, ownerName);

        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        if(procedureType.equals("Repair")){
            return this.repair.history();
        } else if(procedureType.equals("Charge")){
            return this.charge.history();
        }

        return this.work.history();
    }

    public void checkIfRobotExist(String robotName) {
        if (!this.garage.getRobots().containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
    }
}
