package states;

import exceptions.StateException;
import models.Driver;
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
        System.out.println("Успешно встал на ремонт");
    }

    @Override
    public void changeDriver(Truck truck, Driver[] drivers) throws StateException {
        throw new StateException("Грузовик в пути. Невозможно сменить водителя");
    }
}
