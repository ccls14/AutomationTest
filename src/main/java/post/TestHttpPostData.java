package post;

import org.testng.annotations.Test;

public class TestHttpPostData {


    @Test(dataProvider="getCatalogue",dataProviderClass = Data.class)
    public static void getCatalogueTest(String url,String parameters) {
            System.out.println("v1:"+url);
            System.out.println("v2:"+parameters);
        HttpRequestPost httpRequestPost = new HttpRequestPost();
        httpRequestPost.HttpPostData(url, parameters);
    }


    @Test(dataProvider="addCatalogue",dataProviderClass = Data.class)
    public static void addCatalogueTest(String url,String parameters) {
        System.out.println("v1:"+url);
        System.out.println("v2:"+parameters);
        HttpRequestPost httpRequestPost = new HttpRequestPost();
        httpRequestPost.HttpPostData(url, parameters);
    }
}
