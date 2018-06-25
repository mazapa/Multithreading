package by.ryazantseva.multithreading.util;

public class IdGenerator {
    private static long shipId = 1;
    private static long pierId = 1;

    public static Long generateShipId() {
        return shipId++;
    }

    public static Long generatePierId() {
        return pierId++;
    }
}
