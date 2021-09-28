package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParserViaScanner implements Parser {

    private Pattern pattern = Pattern.compile("[Сс]трада");

    @Override
    public ArrayList<String> parse(File file) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            scanner.nextLine();

            var match = scanner.findInLine(pattern);
            if(match != null) {
                list.add(match);
            }

        }
        return list;
    }
}
