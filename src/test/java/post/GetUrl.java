package post;


public class GetUrl {
    public static String getUrl(String path,String parameter) {
        return GetParameter.getParameter("config/ip","ip")+GetParameter.getParameter(path,parameter);
    }
}
