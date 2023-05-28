
package app.okx.coinNames;

import java.io.IOException;
import org.json.JSONArray;

/**
 *
 * @author George Volochaev
 */
public class MainCoinNames {
    public static void main(String[] args)throws IOException {
        
        //CoinsInputData.printJSONArray();
        
        JSONArray Cid = CoinsInputData.getJSONArray();
        //CoinsPrepareData.Print(Cid);
        
        var arr = CoinsPrepareData.getPreparedArr(Cid);
        
        CoinsOutputData.writeJSONArrayToTxtFile(arr, "outfile.txt");
        

    }    
}
