package api;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import parser.Recipe;
import parser.Search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class JsonParser {

    public void parseGSON() throws FileNotFoundException {
        final String JSON = "src/test/resources/testData/expectedAllusers.json";
        File file = new File(JSON);
        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(file)), Data.class);

    }
}
