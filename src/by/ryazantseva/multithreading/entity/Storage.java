package by.ryazantseva.multithreading.entity;

public class Storage {
    private static final int HALF_OF_BOXES = 2;
    private static Storage storage = new Storage();
    private int boxes;

    public static Storage getInstance() {
        return storage;
    }

    private Storage() {
        boxes = 0;
    }

    public void addBoxes(int amountOfBoxes) {
        boxes += amountOfBoxes;
    }

    public void giveBoxes(int amountOfBoxes) {
        if (boxes < amountOfBoxes) {
            boxes += amountOfBoxes - boxes/ HALF_OF_BOXES;
        }
        boxes -= amountOfBoxes;
    }


}
