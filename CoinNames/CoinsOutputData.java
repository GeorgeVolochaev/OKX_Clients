
package app.okx.coinNames;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author George Volochaev
 */
public class CoinsOutputData {
    public static void writeJSONArrayToTxtFile(ArrayList arr, String filePath) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(filePath))) {
            
            for (int i = 0; i < arr.size(); i++) {
                String result = arr.get(i).toString();
                writer.write(result);
                writer.newLine(); 
            }    

            //writer.write(jsonArray.toString(4)); // Specify an optional indentation value
            
            System.out.println("JSONArray successfully written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing JSONArray to file: " + e.getMessage());
        }
    }
}
