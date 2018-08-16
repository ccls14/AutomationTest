package post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHttpPostData {
    @Test(dataProvider="getCatalogue",dataProviderClass = Data.class)
    public void getCatalogueTest(String url, String parameters) {
        JsonObject obj = new Gson().fromJson(HttpRequestPost.httpPostData(url, parameters), JsonObject.class);
        JsonObject data = obj.get("data").getAsJsonObject();
        int id = data.get("id").getAsInt();
        Assert.assertEquals(id,207);
    }


    @Test(dataProvider="addCatalogue",dataProviderClass = Data.class)
    public static void addCatalogueTest(String url,String parameters) {
        JsonObject obj = new Gson().fromJson(HttpRequestPost.httpPostData(url, parameters), JsonObject.class);
        JsonObject data = obj.get("data").getAsJsonObject();
        String name = data.get("name").getAsString();
        System.out.println("name:"+name);
        Assert.assertEquals(name,"aaasaqq");
    }

}
