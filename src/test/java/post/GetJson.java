package post;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class GetJson {

    public static String getJson(String path) {
        BufferedReader br;
        String tmpstr = "";
        String aa = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String s = null;
            while ((s = br.readLine()) != null) {
                tmpstr += s;
            }
            System.out.println(tmpstr);
            JSONObject dataJson = new JSONObject(tmpstr);
            System.out.println(dataJson);
            aa = dataJson.toString();
            br.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(aa);
        return aa;


    }
}
