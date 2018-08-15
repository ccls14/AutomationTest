package post;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GetParameter {
    public static String  getParameter(String path,String par) {
        String parameter = "";
        JsonParser parser = new JsonParser();
        JsonObject object = null;
        try {
            object = (JsonObject) parser.parse(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        parameter = object.get(par).getAsString();
        //System.out.println(url);
         return parameter;

    }


}

