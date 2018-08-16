package post;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.Gson;

public class TestArray {
        @Test(dataProvider="addCatalogue1",dataProviderClass = Data.class)
    public static void addCatalogueTest1(String url,JSONArray parameters) {
            String aa=HttpRequestPostArray.httpPostData(url, parameters);
        JsonObject obj = new Gson().fromJson(aa,JsonObject.class);
        JsonObject data = obj.get("data").getAsJsonObject();
        String name = data.get("name").getAsString();
        System.out.println("name:"+name);
        //Assert.assertEquals(name,"aaasaqq");
    }

}
