package post;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name="getCatalogue")
    public static Object[][] getCatalogue() {
        return new Object[][]{
                {GetUrl.getUrl( "config/uri/getCatalogue", "getCatalogue"),
                        GetJson.getJson("config/parameters/getCatalogue"),
                },
        };
    }

    @DataProvider(name="addCatalogue")
    public static Object[][] addCatalogue() {
        return new Object[][]{
                {GetUrl.getUrl( "config/uri/addCatalogue", "addCatalogue"),
                        GetJson.getJson("config/parameters/addCatalogue"),
                },
        };
    }

}

