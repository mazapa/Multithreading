package by.ryazantseva.multithreading.entity;

public class Pier {
    private static final int MIN_NUMBER_OF_BOXES = 0;
    private Storage storage = Storage.getInstance();
    private long idPier;

    public Pier(long id) {
        idPier = id;
    }

    public void doAction(int amountOfLoadBoxes, int amountOfUnloadBoxes){
        if (amountOfLoadBoxes > MIN_NUMBER_OF_BOXES) {
            storage.addBoxes(amountOfLoadBoxes);
        }
        if (amountOfUnloadBoxes > MIN_NUMBER_OF_BOXES) {
            storage.giveBoxes(amountOfUnloadBoxes);
        }
    }

    public long getIdPier() {
        return idPier;
    }

}
