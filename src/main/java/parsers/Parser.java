package parsers;

import java.io.File;
import java.util.ArrayList;

public interface Parser {
    ArrayList<String> parse(File file);
}
