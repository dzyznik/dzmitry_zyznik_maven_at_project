package parser;

import java.io.IOException;

public class ParserRunner {
    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
//        jsonParser.parseJSON();

        jsonParser.parseGSON();
    }
}
