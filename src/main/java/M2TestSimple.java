import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

public class M2TestSimple {
    public static void main(String[] args) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<contact>\n"+
            "  <address>\n" +
            "    <street>Ave of Nowhere</street>\n" +
            "  </address>\n" +
            "</contact>";
    
        try {
            // Test 1: Without trailing slash
            JSONObject replacement1 = new JSONObject();
            replacement1.put("street", "Ave of the Arts");
            System.out.println("Test 1 - Without trailing slash:");
            System.out.println("Replacement: " + replacement1);
            JSONObject jobj1 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street"), replacement1);
            System.out.println("Result: " + jobj1);
            System.out.println();
            
            // Test 2: With trailing slash
            JSONObject replacement2 = new JSONObject();
            replacement2.put("street", "Ave of the Arts");
            System.out.println("Test 2 - With trailing slash:");
            System.out.println("Replacement: " + replacement2);
            JSONObject jobj2 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"), replacement2);
            System.out.println("Result: " + jobj2);
            System.out.println();
            
            // Test 3: Using XML.toJSONObject to create replacement
            JSONObject replacement3 = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            System.out.println("Test 3 - Using XML.toJSONObject for replacement:");
            System.out.println("Replacement: " + replacement3);
            JSONObject jobj3 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street"), replacement3);
            System.out.println("Result: " + jobj3);
            System.out.println();
            
            // Test 4: Using a different path
            JSONObject replacement4 = new JSONObject();
            replacement4.put("address", new JSONObject().put("street", "Ave of the Arts"));
            System.out.println("Test 4 - Using a different path:");
            System.out.println("Replacement: " + replacement4);
            JSONObject jobj4 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact"), replacement4);
            System.out.println("Result: " + jobj4);
            System.out.println();
            
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
