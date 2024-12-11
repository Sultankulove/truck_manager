package states;

import exceptions.StateException;
import models.Driver;
import models.Truck;

import java.util.Random;

public class OnRepair implements State {
    @Override
    public void startDriving(Truck truck) {
        Random random = new Random();
        int rnd = random.nextInt(2)+1;
        if (rnd < 2) {
            truck.setState("On base");
            truck.setStateObj(new OnBase());
            System.out.println("Грузовик поехал на базу");
        } else {
            truck.setState("On route");
            truck.setStateObj(new OnRoute());
            System.out.println("Грузовик отправился в рейс");
        }
//        switch (rnd) {
//            case 1: {
//                truck.setStateObj(new OnBase());
//                truck.setState("On base");
//                break;
//            }
//            case 2: {
//                truck.setStateObj(new OnRoute());
//                truck.setState("On route");
//                break;
//            }
//        }
    }

    @Override
    public void startRepair(Truck truck) throws StateException{
        throw new StateException("Уже в ремонте");
    }

    @Override
    public void changeDriver(Truck truck, Driver[] drivers) throws StateException {
        throw new StateException("Грузовик на ремонте");
    }
}
