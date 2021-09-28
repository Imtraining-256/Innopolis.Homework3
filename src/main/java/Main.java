import parsers.Parser;
import parsers.ParserViaBufferedReader;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parser buffParse = new ParserViaBufferedReader();
        var file = new File("voyna.txt");

        ArrayList<String> list = buffParse.parse(file);

        list.forEach(System.out::println);
        System.out.println(list.size());
    }
}
