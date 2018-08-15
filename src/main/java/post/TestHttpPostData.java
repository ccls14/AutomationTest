package post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHttpPostData {
    Gson gs = new Gson();
    @Test(dataProvider="getCatalogue",dataProviderClass = Data.class)
    public void getCatalogueTest(String url, String parameters) {
        JsonObject obj1 = gs.fromJson(HttpRequestPost.httpPostData(url, parameters), JsonObject.class);
        JsonObject data = obj1.get("data").getAsJsonObject();
        int id = data.get("id").getAsInt();
        System.out.println("id:"+id);
        Assert.assertEquals(id,207);
    }


    @Test(dataProvider="addCatalogue",dataProviderClass = Data.class)
    public static void addCatalogueTest(String url,String parameters) {
        HttpRequestPost.httpPostData(url, parameters);
    }
}
