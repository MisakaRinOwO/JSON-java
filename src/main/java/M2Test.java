import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONPointer;
import org.json.JSONObject;
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
    
        String xmlString2 = "<?xml version=\"1.0\"?>\n"+ 
            "<catalog>\n" +
            "  <book id=\"bk101\">\n" +
            "    <author>Gambardella, Matthew</author>\n" +
            "    <title>XML Developer's Guide</title>\n" +
            "    <genre>Computer</genre>\n" +
            "    <price>44.95</price>\n" +
            "    <publish_date>2000-10-01</publish_date>\n" +
            "    <description>An in-depth look at creating applications\n" + 
            "    with XML.</description>\n" +
            "  </book>\n" +
            "  <book id=\"bk102\">\n" +
            "    <author>Ralls, Kim</author>\n" +
            "    <title>Midnight Rain</title>\n" +
            "    <genre>Fantasy</genre>\n" +
            "    <price>5.95</price>\n" +
            "    <publish_date>2000-12-16</publish_date>\n" +
            "    <description>A former architect battles corporate zombies, \n" +
            "    an evil sorceress, and her own childhood to become queen \n" +
            "    of the world.</description>\n" +
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
            System.out.println(XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street")) + "\n");
            // System.out.println("-----------------------");
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog")));
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book/title")));
            // System.out.println(XML.toJSONObject(new StringReader(xmlString2), new JSONPointer("/catalog/book/price")));
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("-----------------------");

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