package http;

import org.testng.annotations.Test;

public class TestGet {
    @Test
    public void testGet() throws Exception {
        RequestGet requestGet = new  RequestGet();
    //    requestGet.requestGet1("http://119.147.19.43/v3/user/get_info");
        requestGet.requestGet1("http://www.baidu.com");
    }
    }
