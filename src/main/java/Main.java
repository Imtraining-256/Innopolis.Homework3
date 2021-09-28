import parsers.Parser;
import parsers.ParserViaBufferedReader;
import parsers.ParserViaScanner;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParserViaBufferedReader buffParse = new ParserViaBufferedReader();
        var file = new File("voyna.txt");

        ArrayList<String> list = buffParse.parse(file);

        list.forEach(System.out::println);
        System.out.println("======");
        System.out.println(list.size());


        for(int i = 1; i <= 10; i++){
            for(int k = 1; k <= 10; k++){
                System.out.printf("%4d", (i * k));
            }
            System.out.println("");
        }
    }
}
