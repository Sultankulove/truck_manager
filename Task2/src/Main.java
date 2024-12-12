import models.Driver;
import models.Truck;
import utils.FileUtil;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Truck[] trucks = FileUtil.readTruckFile();
        Driver[] drivers = FileUtil.readDriverFile();

        if (trucks.length == 0 || drivers.length == 0) {
            System.out.println("Нет данных. Дальнейшая работа невозможна");
            exit(500);
        }

        Truck truck = trucks[1];
        truck.startDriving();
        truck.changeDriver(drivers);
        truck.startDriving();
        truck.changeDriver(drivers);
        truck.startRepair();
        truck.changeDriver(drivers);
        truck.startDriving();
    }
}
