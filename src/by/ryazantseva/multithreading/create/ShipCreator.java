package by.ryazantseva.multithreading.create;

import by.ryazantseva.multithreading.entity.Port;
import by.ryazantseva.multithreading.entity.Ship;
import by.ryazantseva.multithreading.exception.InvalidInputDataException;
import by.ryazantseva.multithreading.util.IdGenerator;
import java.util.List;

public class ShipCreator {
    public static final int NUMBER_OF_BOXES = 2;

    public Ship buildShip(List<Integer> numbersOfBoxes, Port port) throws InvalidInputDataException {
        Ship ship;
        if (numbersOfBoxes.size() != NUMBER_OF_BOXES) {
            throw new InvalidInputDataException("Incorrect input list with boxes!");
        }
        ship = new Ship(numbersOfBoxes.get(ShipActionType.LOAD.ordinal()),numbersOfBoxes.get(ShipActionType.UNLOAD.ordinal()),IdGenerator.generateShipId(),port);
        return ship;
    }
}

