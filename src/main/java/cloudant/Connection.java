package cloudant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

public class Connection{
	
	private HttpClient httpClient;
	private CouchDbConnector dbc;
	
	private int port;
	private String name;
	private String host;
	private String username;
	private String password;
	
	private static JSONArray cloudant;
	private static JSONObject cloudantInstance;
	private static JSONObject cloudantCredentials;
	
	public Connection(){
		
		this.httpClient = null;
		
		try {
			String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
			JSONObject vcap;
			vcap = (JSONObject)JSONObject.parse(VCAP_SERVICES);
			
			cloudant = (JSONArray)vcap.get("cloudantNoSQLDB");
			cloudantInstance = (JSONObject)cloudant.get(0);
			cloudantCredentials = (JSONObject)cloudantInstance.get("credentials");		
		}
		catch(Exception e){}
		
		this.port = Config.CLOUDANT_PORT;
		this.host = (String) cloudantCredentials.get("host");
		this.username = (String) cloudantCredentials.get("username");
		this.password = (String) cloudantCredentials.get("password");
		this.name = Config.CLOUDANT_NAME;
		this.dbc = this.createDBConnector();
	
		System.out.println(dbc);
	}
	
	
	private CouchDbConnector createDBConnector() 
	{
		CouchDbInstance dbInstance = null;
		
		System.out.println("Creating CouchDB instance...");
		System.out.println(this.username);
		this.httpClient = new StdHttpClient.Builder()
		.host(this.host)
		.port(this.port)
		.username(this.username)
		.password(this.password)
		.enableSSL(true)
		.relaxedSSLSettings(true)
		.build();

		dbInstance = new StdCouchDbInstance(this.httpClient);
		CouchDbConnector dbc = new StdCouchDbConnector(this.name, dbInstance);
		/*dbc.createDatabaseIfNotExists();
		if (dbc.getAllDocIds().size() == 0) {
			dbc.replicateFrom("https://jsloyer.cloudant.com/talent-manager");
			while (true) {
				if (dbc.getAllDocIds().size() == 117) {
					break;
				}
				else {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}*/
		return dbc;
	}
	
	public void closeDBConnector()
	{
		if (httpClient != null)
		{
			httpClient.shutdown();
		}
	}
	
	/*CloudantClient client = ClientBuilder.account("af5a6228-493b-4575-99e9-acbc4b9ea484-bluemix")
            .username("af5a6228-493b-4575-99e9-acbc4b9ea484-bluemix")
            .password("2e256c7702f5c62aba1955edb146903a1d8ef1a11521301856baec18ad3d9203")
            .build();	
	
	public void testConnection(){
		System.out.println(client.serverVersion());
	}*/

}
