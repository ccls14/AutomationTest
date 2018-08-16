package post;


import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetJsonArray {

    public static JSONArray getJson(String path) {
        BufferedReader br;
        String tmpstr = "";
        //JSONArray dataJson1 ;
        JSONArray dataJson = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String s = null;
            while ((s = br.readLine()) != null) {
                tmpstr += s;
            }
            System.out.println(tmpstr);
            dataJson = new JSONArray(tmpstr);
            //System.out.println(dataJson.toString());
            System.out.println(dataJson);
//            for (int i = 0; i < dataJson.length(); i++) {
//                JSONObject jsonObject = dataJson.getJSONObject(i);
//                System.out.println(jsonObject.toString());
//
//            }
            br.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //System.out.println(aa);
        System.out.println(dataJson.get(1));
        return dataJson;


    }
}
