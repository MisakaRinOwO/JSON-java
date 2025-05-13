import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class M3Test {
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

        String xmlString2 = 
            "<?xml version=\"1.0\"?>\n"+ 
            "<catalog>\n" +
            "  <book id=\"bk101\">\n" +
            "    <author>Author 1</author>\n" +
            "    <title>Book 1</title>\n" +
            "  </book>\n" +
            "  <book id=\"bk102\">\n" +
            "    <author>Author 2</author>\n" +
            "    <title>Book 2</title>\n" +
            "  </book>\n" +
            "</catalog>\n";

        try {
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), key -> "swe262_" + key);
            System.out.println(jobj); 
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("\n");

        try {
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString2), key -> "swe262_" + key);
            System.out.println(jobj); 
        } catch (JSONException e) {
            System.out.println(e);
        }
        System.out.println("\n");
    }

}