package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParserViaScanner implements Parser {

    private Pattern pattern = Pattern.compile("[Сс]трада");

    @Override
    public ArrayList<String> parse(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var matches = scanner.findAll(pattern).map(MatchResult::group).collect(Collectors.toList());

        ArrayList<String> list = new ArrayList<>(matches);

        return list;
    }
}
