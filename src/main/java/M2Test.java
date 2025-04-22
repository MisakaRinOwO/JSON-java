import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

// javac -cp ".;.\json-java.jar" M2Test.java

public class M2Test {
    public static void main(String[] args) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<contact>\n"+
            "  <nick>Crista </nick>\n"+
            "  <name>Crista Lopes</name>\n" +
            "  <address>\n" +
            "    <street>Ave of Nowhere</street>\n" +
            "    <zipcode>92614</zipcode>\n" +
            "  </address>\n" +
            "</contact>";
    
        try {
            JSONObject jobj = XML.toJSONObject("  <name>Crista Lopes</name>");
            JSONPointer pt = new JSONPointer("/contact/address/street/");
            String ps = pt.toString();
            System.out.println(jobj);
            String[] pathArray = ps.substring(1).split("/+");
            System.out.print(pathArray[1]);
            
        } catch (JSONException e) {
            System.out.println(e);
        }

        // try {
        //     JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"));
        //     System.out.println(jobj); 
        // } catch (JSONException e) {
        //     System.out.println(e);
        // }

        // System.out.println("-----------------------");

        // try {
        //     JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
        //     System.out.println("Given replacement: " + replacement);
        //     JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"), replacement);
        //     System.out.println(jobj); 
        // } catch (JSONException e) {
        //     System.out.println(e);
        // }
    }
}