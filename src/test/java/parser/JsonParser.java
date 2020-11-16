package parser;



import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JsonParser {

    private final String JSON = "src/test/resources/testData/iceCream.json";

    File file = new File(JSON);

    public void parseJSON() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(JSON)));
        JSONObject obj = new JSONObject(input);
        System.out.println(obj.getString("recipename"));

        System.out.println(obj.getJSONArray("ingredlist").getJSONObject(1).getString("itemdescription"));

    }

    public void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(file)), Recipe.class);
        System.out.println(recipe.recipename);
        System.out.println(Arrays.stream(recipe.ingredlist));
        System.out.println(recipe.preptime);
    }

    public static String fromGSON(Search search){
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}
