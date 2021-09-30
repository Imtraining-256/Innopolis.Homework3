package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParserViaScanner implements Parser {

    private static final String WORD_TO_FIND = "[Сс]трада";
    private final Pattern pattern = Pattern.compile(WORD_TO_FIND);

    @Override
    public ArrayList<String> parse(File file) {
        Scanner scanner = null;

        ArrayList<String> matches = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            matches = scanner.findAll(pattern)
                    .map(MatchResult::group)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return matches;
    }
}
