package states;

import models.Driver;
import models.Truck;
import models.DriverRegistry;

public class OnBase implements State {

    @Override
    public void startDriving(Truck truck) {
        truck.setStateObj(new OnRoute());
        truck.setState("On route");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("On repair");
    }

    @Override
    public void changeDriver(Truck truck) {
        if (truck.getDriverObj() != null) {
            System.out.println("Грузовик уже имеет водителя: " + truck.getDriverObj().getName());
            return;
        }

        Driver availableDriver = DriverRegistry.getAvailableDriver();


        if (availableDriver != null) {
            truck.setDriverObj(availableDriver);
            availableDriver.setAssigned(true);
            System.out.println("Теперь грузовик " + truck.getName() + " ведет водитель " + availableDriver.getName());
        } else {
            System.out.println("Нет доступных водителей для грузовика " + truck.getName());
        }
    }
}
