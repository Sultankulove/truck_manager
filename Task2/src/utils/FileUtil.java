package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Driver;
import models.Truck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static Truck[] readTruckFile() {
        try {
            String str = Files.readString(Paths.get("Task2/src/data/trucks.json"));
            return GSON.fromJson(str, Truck[].class);

        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return new  Truck[3];
    }

    public static Driver[] readDriverFile() {
        try {
            String str = Files.readString(Paths.get("Task2/src/data/driver.json"));
            return GSON.fromJson(str, Driver[].class);

        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return new  Driver[3];
    }

//    public static void writeFail(Truck[] trucks) {
//        String newJson = GSON.toJson(trucks);
//
//        byte[] bytes = newJson.getBytes();
//
//        try {
//            Files.write(PATH, bytes);
//        } catch (IOException e) {
//            e.getMessage();
//            e.printStackTrace();
//        }
//    }
}
