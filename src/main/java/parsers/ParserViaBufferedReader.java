package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ParserViaBufferedReader implements Parser{

    private Pattern pattern = Pattern.compile("[Сс]трада\\w*");

    @Override
    public ArrayList<String> parse(File file) {
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            var line = reader != null ? reader.readLine() : null;

            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        var filteredList = list.stream().filter(pattern.asPredicate()).collect(Collectors.toList());

        ArrayList<String> matches = new ArrayList<>(filteredList);
        return matches;
    }
}