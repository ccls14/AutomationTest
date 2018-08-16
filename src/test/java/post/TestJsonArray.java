package post;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestJsonArray {
    private static Logger logger = Logger.getLogger(TestJsonArray.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("conf/log4j.properties");
         GetJsonArray.getJson("config/parameters/addCatalogue1");

    }
}
