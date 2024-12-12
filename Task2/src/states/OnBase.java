package states;

import exceptions.StateException;
import models.Driver;
import models.Truck;

public class OnBase implements State {

    @Override
    public void startDriving(Truck truck) throws StateException {
        if (!truck.getDriver().isBlank()){

            truck.setStateObj(new OnRoute());
            truck.setState("On route");
            System.out.println("Успешно отправлен на маршрут");

        } else {
            throw new StateException("Ошибка! Невозможно ехать без водителя");
        }
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("On repair");
        System.out.println("Успешно встал на ремонт");
    }

    @Override
    public void changeDriver(Truck truck, Driver[] drivers) throws StateException {
        int freeDriver = -1;
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].getTruck() == null || drivers[i].getTruck().isBlank()) {
                freeDriver = i;
                break;
            }
        }

        if (freeDriver < 0) {
            throw new StateException("Нет свободных водителей");
        }

        for (Driver driver : drivers) {
            if (truck.getName().equals(driver.getTruck())) {
                driver.setTruck("");
                break;
            }
        }

        drivers[freeDriver].setTruck(truck.getName());
        truck.setDriver(drivers[freeDriver].getName());
//        if (truck.getDriverObj() != null) {
//            System.out.println("Грузовик уже имеет водителя: " + truck.getDriverObj().getName());
//            return;
//        }
//
//        Driver availableDriver = DriverRegistry.getAvailableDriver();
//
//
//        if (availableDriver != null) {
//            truck.setDriverObj(availableDriver);
//            availableDriver.setAssigned(true);
//            System.out.println("Теперь грузовик " + truck.getName() + " ведет водитель " + availableDriver.getName());
//        } else {
//            System.out.println("Нет доступных водителей для грузовика " + truck.getName());
//        }
    }
}
