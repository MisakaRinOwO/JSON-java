import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

// javac -cp ".;.\json-java.jar" M2Test.java

/* small test class for Milestone 2 */
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

        String xmlString3 = 
            "<?xml version=\"1.0\"?>\n"+ 
            "<catalog>\n" +
            "  <book>\n" +
            "    <author>Author 1</author>\n" +
            "    <title>Book 1</title>\n" +
            "  </book>\n" +
            "  <book>\n" +
            "    <author>Author 2</author>\n" +
            "    <title>Book 2</title>\n" +
            "  </book>\n" +
            "  <book>\n" +
            "    <author>Author 3</author>\n" +
            "    <title>Book 3</title>\n" +
            "  </book>\n" +
            "</catalog>\n";

        // JSONObject jobj = XML.toJSONObject("  <name>Crista Lopes</name>");
        // System.out.println(new JSONPointer("/catalog").queryFrom(XML.toJSONObject(xmlString2)) + "\n");
        // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog")) + "\n");

        // System.out.println(new JSONPointer("/catalog/book/0").queryFrom(XML.toJSONObject(xmlString2)) + "\n");
        // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book/0")) + "\n");
        

        try {
            // JSONObject jobj2 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street"));
            // System.out.println(new JSONPointer("/contact").queryFrom(XML.toJSONObject(xmlString)) + "\n");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact")) + "\n");
            // System.out.println(new JSONPointer("/contact/address").queryFrom(XML.toJSONObject(xmlString)) + "\n");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address")) + "\n");
            // System.out.println(new JSONPointer("/contact/address/street").queryFrom(XML.toJSONObject(xmlString)) + "\n");
            // System.out.println((new JSONPointer("/contact/address/street").queryFrom(XML.toJSONObject(xmlString))) instanceof JSONObject);


            // Case: Object value is ArrayList
            // System.out.println(new JSONPointer("/catalog/book").queryFrom(XML.toJSONObject(xmlString2)) + "\n" + "\n");
            // System.out.println((new JSONPointer("/catalog/book/0").queryFrom(XML.toJSONObject(xmlString2))) instanceof JSONObject);
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog")) + "\n" + "\n");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book")) + "\n" + "\n");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString3)));

            // Basic
            // System.out.println(new JSONPointer("/contact/address").queryFrom(XML.toJSONObject(xmlString)) + "\n" + "\n");
            System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/")) + "\n" + "\n");
            System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address")) + "\n" + "\n");
            // System.out.println("-----------------------");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog")));
            // System.out.println(XML.toJSONObject(new StringReader(xmlString3), new JSONPointer("/catalog/book/author")));
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book/")));
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2)) + "\n" + "\n");
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("-----------------------");

        try {
            JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            System.out.println("Given replacement: " + replacement);
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"), replacement);
            System.out.println(jobj); 
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}