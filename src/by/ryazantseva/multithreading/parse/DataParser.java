package by.ryazantseva.multithreading.parse;
import by.ryazantseva.multithreading.exception.InvalidInputDataException;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private static final String ONE_NUMBER = "\\d+";

    public List<Integer> parseDataForShip(String stringWithBoxes) throws InvalidInputDataException {
        if (stringWithBoxes.isEmpty()) {
            throw new InvalidInputDataException("String is empty");
        }
        List<Integer> numbOfBoxes = new LinkedList<>();
        Pattern pattern = Pattern.compile(ONE_NUMBER);
        Matcher matcher = pattern.matcher(stringWithBoxes);
       while (matcher.find()) {
            numbOfBoxes.add(Integer.parseInt(stringWithBoxes.substring(matcher.start(), matcher.end())));
        }
        return numbOfBoxes;
    }

    public Integer parseDataForPort(String stringWithNumbPiers) throws InvalidInputDataException {
        Pattern pattern = Pattern.compile(ONE_NUMBER);
        Matcher matcher = pattern.matcher(stringWithNumbPiers);
        if (!matcher.find()){
            throw new InvalidInputDataException("Incorrect data!");
        }
        return Integer.parseInt(stringWithNumbPiers);
    }


}
