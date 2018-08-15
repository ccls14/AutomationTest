//package http;
//
//import net.sf.json.JSONObject;
//
//import java.io.*;
//import java.util.*;
//
//public class GetJson1 {
//
//    String filepat = "/static/mobile/config.json";
//    String filepath = request.getRealPath(filepat);
//    InputStreamReader read = new InputStreamReader(new FileInputStream(filepath), "UTF-8");
//    BufferedReader br = new BufferedReader(read);
//    String s = "";
//    //String ws = "";
//    String tmpstr = "";
//while ((s = br.readLine()) != null) {
//        tmpstr += s;
//    }
//System.out.println(tmpstr);
//    JSONObject dataJson = JSONObject.fromObject(tmpstr);
//}
