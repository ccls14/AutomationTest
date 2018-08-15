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
        String space = obj1.get("space").getAsString();
        System.out.println("space:"+space);
    }


    @Test(dataProvider="addCatalogue",dataProviderClass = Data.class)
    public static void addCatalogueTest(String url,String parameters) {
        HttpRequestPost.httpPostData(url, parameters);
    }
}
