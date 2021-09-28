package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParserViaBufferedReader implements Parser{

    private Pattern pattern = Pattern.compile("(^|\\A|\\s|)[Сс]трада.*?(\\s|$|)");

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
                var matcher = pattern.matcher(line);
                if (matcher.find())
                    list.add(matcher.group());
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}