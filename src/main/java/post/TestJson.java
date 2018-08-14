package post;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestJson {
    private static Logger logger = Logger.getLogger(TestJson.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("conf/log4j.properties");
         GetJson.getJson("config/parameters/getCatalogue");

    }
}
