package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParserViaBufferedReader implements Parser{

    private Pattern pattern = Pattern.compile("[Сс]трада\\w*(.*)");
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
        }

        return list;
    }

    private void addWord(String line){
        var words = line.split("\\P{L}+");

        for(String word : words) {
            if(word.matches("(.*)[Сс]трада(.*)")){
                list.add(word);
            }
        }
    }
}