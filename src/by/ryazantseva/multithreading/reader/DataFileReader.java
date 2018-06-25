package by.ryazantseva.multithreading.reader;

import by.ryazantseva.multithreading.exception.DataFileReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFileReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String fileName) throws DataFileReaderException {
        List<String> stringsWithData;
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            logger.log(Level.FATAL, "Wrong file!");
            throw new RuntimeException();
        }
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stringsWithData = stream
                    .collect(Collectors.toList());
            logger.log(Level.INFO, "File has been read successfully");
        } catch (IOException e) {
            throw new DataFileReaderException("Problem with reading file", e);
        }
        return stringsWithData;
    }



}