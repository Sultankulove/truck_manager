package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Truck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("data/trucks.json");
    public static Truck[] readFile() {
        try {
            String str = Files.readString(PATH);
            return GSON.fromJson(str, Truck[].class);

        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return new  Truck[3];
    }

    public static void writeFail(Truck[] trucks) {
        String newJson = GSON.toJson(trucks);

        byte[] bytes = newJson.getBytes();

        try {
            Files.write(PATH, bytes);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
