package post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;


import java.io.IOException;
public class HttpRequestPost {


    public static String httpPostData(String url,String parameters) {
        String rev =null;
        JsonParser parser = new JsonParser();
        JsonObject obj = null;
        Gson gs = new Gson();
        try {
            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost(url);
            //添加http头信息
            httppost.addHeader("Authorization", "your token"); //认证token
            httppost.addHeader("Content-Type", "application/json");
            httppost.addHeader("User-Agent", "imgfornote");
            httppost.addHeader("Cookie", "dt_user_id=1; dt_username=admin%40dtstack.com; dt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRfaWQiOiIxIiwidXNlcl9pZCI6IjEiLCJ1c2VyX25hbWUiOiJhZG1pbkBkdHN0YWNrLmNvbSIsImV4cCI6MTU0OTY4Mjc0OSwiaWF0IjoxNTM0MTMwNzQ5fQ.TpFkYRY-aboFAQqb-bcn0qI6Ft8E0k8mONkyLHUEe6s; dt_tenant_id=1; dt_tenant_name=DTStack%E7%A7%9F%E6%88%B7; dt_is_tenant_admin=true; dt_is_tenant_creator=true; DT_SESSION_ID=04d00a9c-f66b-4d7f-9137-f8327d430d04; project_id=8");

            obj = gs.fromJson(parameters, JsonObject.class);
            httppost.setEntity(new StringEntity(obj.toString()));
            System.out.println(obj.toString());
            HttpResponse response;
            response = httpclient.execute(httppost);
            //System.out.println(response);
            //检验状态码，如果成功接收数据
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code);
            if (code == 200) {
                rev = EntityUtils.toString(response.getEntity());//返回json格式： {"id": "27JpL~j4vsL0LX00E00005","version": "abc"}
                //System.out.println(rev);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return rev;
    }
}