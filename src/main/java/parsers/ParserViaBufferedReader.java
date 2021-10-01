package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParserViaBufferedReader implements Parser{

    private static final String WORD_TO_FIND = "(.*)[Сс]трада(.*)";
    private static final String WORDS_SEPARATE = "\\P{L}+";

    private final Pattern pattern = Pattern.compile(WORD_TO_FIND);

    private ArrayList<String> list = new ArrayList<>();

    @Override
    public ArrayList<String> parse(File file) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            var line = reader.readLine();
            while (line != null) {
                var matcher = pattern.matcher(line);

                if (matcher.find()){
                    addWord(line);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    private void addWord(String line){
        var words = line.split(WORDS_SEPARATE);

        for(String word : words) {
            if(word.matches(WORD_TO_FIND)){
                list.add(word);
            }
        }
    }
}