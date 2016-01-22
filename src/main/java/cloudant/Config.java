package cloudant;

import com.cloudant.client.api.CloudantClient;

public class Config 
{
    
    /** Cloudant **/
    public static final int CLOUDANT_PORT = 443;
    public static final String CLOUDANT_NAME = "Cloudant NoSQL DB-uy";
    
    /** Watson User Modeling **/
    
    public static final String WATSON_PROF_API = "/api/v2/profile";
    public static final String WATSON_VIZ_API = "/api/v2/visualize";
    
    public static Connection cc = new Connection();

    /* Mobile Data Config */
    public static final String MOBILE_DATA_APP_ID = "";
    public static final String MOBILE_DATA_APP_SECRET = "";
}
