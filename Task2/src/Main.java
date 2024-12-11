import models.Driver;
import models.Truck;
import utils.FileUtil;

public class Main {
    public static void main(String[] args) {
        Truck[] trucks = FileUtil.readTruckFile();
        Driver[] drivers = FileUtil.readDriverFile();

    }
}
