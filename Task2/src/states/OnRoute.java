package states;

import exceptions.StateException;
import models.Truck;

public class OnRoute implements State {
    @Override
    public void startDriving(Truck truck) throws StateException {
        throw new StateException("Грузовик уже в пути");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("On repair");
    }

    @Override
    public void changeDriver(Truck truck) throws StateException {
        throw new StateException("Грузовик в пути");
    }
}
