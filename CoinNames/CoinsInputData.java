
package app.okx.coinNames;

import java.io.IOException;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author George Volochaev
 */
public class CoinsInputData {
    private static final String API_BASE_URL = "https://www.okx.com/api/v5";
    private static final String END_POINT = "/public/instruments?instType=SPOT";
    private static final String KEY_DATA = "data";
    private static final String KEY_INST_ID = "instId";
    
    public static void printJSONArray()throws IOException{
        
        JSONArray jArr = getJSONArray();
        
        for (int i = 0; i < jArr.length(); i++) {
                JSONObject instrument = jArr.getJSONObject(i);
                String instId = instrument.getString(KEY_INST_ID);
                System.out.println(instId);
            } 
    } 
    public static JSONArray getJSONArray() throws IOException{
        var json = getJSONObject(getResponseBody());
        return json.getJSONArray(KEY_DATA);
    }
    
    private static String getResponseBody() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String responseBody = "";
        
        Request request = new Request.Builder()
                .url(API_BASE_URL + END_POINT)
                .build();
        Response response = client.newCall(request).execute();
        
        if (response.isSuccessful()) {
            responseBody = response.body().string();
            
        } else {
            System.out.println("Failed to retrieve instrument IDs. Error code: " + response.code());
        }
    
        return responseBody;
    }
    private static JSONObject getJSONObject(String responseBody){
        return new JSONObject(responseBody);
    }
    
    
}
