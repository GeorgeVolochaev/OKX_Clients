
package app.okx.coinNames;

import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author George Volochaev
 */
public class CoinsPrepareData {
    private static final String KEY_USDT    = "-USDT";
    private static final String KEY_INST_ID = "instId";
    
    public static void Print(JSONArray jsonArray){
        ArrayList arr = getPreparedArr(jsonArray);
        
        for (int i = 0; i < arr.size(); i++) {
            String currStr = arr.get(i).toString();  
            System.out.println(currStr);
        }
    }
    public static ArrayList getPreparedArr(JSONArray jsonArray){
        ArrayList ArrOnlyUsdt = getArrOnlyUsdtStrings(jsonArray);
        ArrayList ArrDel      = deleteArrUsdtStrings(ArrOnlyUsdt);
        ArrayList ArrSorted   = sortArr(ArrDel);
        
        return ArrOnlyUsdt;
    }
    
    private static ArrayList getArrOnlyUsdtStrings(JSONArray jsonArray){
        ArrayList<String> resultArr = new ArrayList<>();
        
        for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject instrument = jsonArray.getJSONObject(i);
                String instId = instrument.getString(KEY_INST_ID);
                
                if (instId.contains(KEY_USDT)){   
                    resultArr.add(instId);
                }          
            }   
        return resultArr;
    }
    private static ArrayList deleteArrUsdtStrings(ArrayList arr){
            for (int i = 0; i < arr.size(); i++) {
                    String currStr = arr.get(i).toString();
                    String resultStr = currStr.replaceAll("-USDT","");  
                    arr.set(i, resultStr);              
                }   
            
        return arr;
    }
    private static ArrayList sortArr(ArrayList arr){
        Collections.sort(arr);       
        return arr;
    }
}
