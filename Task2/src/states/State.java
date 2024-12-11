package states;

import exceptions.StateException;
import models.Truck;

public interface State {

    void startDriving(Truck truck) throws StateException;

    void startRepair(Truck truck) throws StateException;

    void changeDriver(Truck truck) throws StateException;
}
