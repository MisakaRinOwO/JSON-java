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
            // System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/")) + "\n" + "\n");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address")) + "\n" + "\n");
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
            // JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            JSONObject replacement = XML.toJSONObject("<nick>Replaced nick</nick>\n");
            System.out.println("Given replacement: " + replacement);
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/nick/"), replacement);
            System.out.println(jobj + "\n"); 

            // JSONObject replacement2 = XML.toJSONObject(
            //     "  <address>\n" +
            //     "    <street>Address 2</street>\n" +
            //     "    <zipcode>zipcode 2</zipcode>\n" +
            //     "  </address>\n");
            // System.out.println("Given replacement2: " + replacement2);
            // JSONObject jobj2 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/"), replacement2);
            // System.out.println(jobj2 + "\n"); 

            JSONObject replacement3 = XML.toJSONObject(
                "  <address>\n" +
                "    <street>Address insert 1</street>\n" +
                "    <zipcode>zipcode insert 1</zipcode>\n" +
                "  </address>\n" +
                "  <address>\n" +
                "    <street>Address insert 2</street>\n" +
                "    <zipcode>zipcode insert 2</zipcode>\n" +
                "  </address>\n" +
                "  <address>\n" +
                "    <street>Address insert 3</street>\n" +
                "    <zipcode>zipcode insert 3</zipcode>\n" +
                "  </address>\n");
            System.out.println("Given replacement3: " + replacement3);
            JSONObject jobj3 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/"), replacement3);
            System.out.println(jobj3 + "\n"); 

            // String expectedString2 =  "<?xml version=\"2.0\" encoding=\"UTF-8\"?>\n"+
            // "<contact>\n"+
            // "  <nick>Crista </nick>\n"+
            // "  <name>Crista Lopes</name>\n" +
            // "  <address>\n" +
            // "    <street>Address insert 1</street>\n" +
            // "    <zipcode>Zipcode insert 1</zipcode>\n" +
            // "  </address>\n" +
            // "  <address>\n" +
            // "    <street>Address insert 1</street>\n" +
            // "    <zipcode>Zipcode insert 1</zipcode>\n" +
            // "  </address>\n" +
            // "</contact>";
            // JSONObject expectedJson2 = new JSONObject(expectedString2);
            // System.out.println(expectedJson2);

            // JSONObject replacement4 = XML.toJSONObject("<address>address element inserted</address>\n");
            // System.out.println("Given replacement4: " + replacement4);
            // JSONObject jobj4 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/"), replacement4);
            // System.out.println(jobj4 + "\n"); 

            JSONObject replacement5 = XML.toJSONObject("  <book>\n" +
                "    <author>Author insert</author>\n" +
                "    <title>Book insert</title>\n" +
                "  </book>\n");
            JSONObject replacement6 = XML.toJSONObject("<author>Author insert</author>");
            System.out.println("Given replacement6: " + replacement6);
            JSONObject jobj5 = XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book/author"), replacement6);
            System.out.println(jobj5 + "\n"); 
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}