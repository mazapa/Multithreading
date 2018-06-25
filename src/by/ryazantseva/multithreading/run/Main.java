package by.ryazantseva.multithreading.run;
import by.ryazantseva.multithreading.create.ShipCreator;
import by.ryazantseva.multithreading.entity.Port;
import by.ryazantseva.multithreading.entity.Ship;
import by.ryazantseva.multithreading.exception.DataFileReaderException;
import by.ryazantseva.multithreading.exception.InvalidInputDataException;
import by.ryazantseva.multithreading.parse.DataParser;
import by.ryazantseva.multithreading.reader.DataFileReader;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "files/data.txt";
    public static final int NUMBER_OF_PIERS = 0;

    public static void main(String[] args) throws DataFileReaderException, InvalidInputDataException {
        DataParser parser = new DataParser();
        ShipCreator creator = new ShipCreator();
        List<String> strings = new DataFileReader().readFromFile(FILE_NAME);
        int amountOfPiers = parser.parseDataForPort(strings.get(NUMBER_OF_PIERS));
        strings.remove(NUMBER_OF_PIERS);
        Port port = Port.getInstance(amountOfPiers);
        for (int startIndex = 0; startIndex < amountOfPiers; startIndex++) {
            port.addPier();
        }
        for (String string : strings) {
            Ship ship = creator.buildShip(parser.parseDataForShip(string), port);
            ship.start();
        }

    }
}
