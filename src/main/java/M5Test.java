
import java.io.StringReader;

import org.json.XML;

public class M5Test {
    public static void main(String[] args) {
        String xml1= "<?xml version=\"1.0\"?>\n"+ 
                "<catalog>\n" +
                "  <book id=\"bk101\">\n" +
                "    <author>Author 1</author>\n" +
                "    <title>Book 1</title>\n" +
                "  </book>\n" +
                "</catalog>\n";

        String xml2= "<?xml version=\"1.0\"?>\n"+ 
                "<catalog>\n" +
                "  <book id=\"bk101\">\n" +
                "    <author>Author 1</author>\n" +
                "    <title>Book 1</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk102\">\n" +
                "    <author>Author 2</author>\n" +
                "    <title>Book 2</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk103\">\n" +
                "    <author>Author 3</author>\n" +
                "    <title>Book 3</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk104\">\n" +
                "    <author>Author 4</author>\n" +
                "    <title>Book 4</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk105\">\n" +
                "    <author>Author 5</author>\n" +
                "    <title>Book 5</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk106\">\n" +
                "    <author>Author 6</author>\n" +
                "    <title>Book 6</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk107\">\n" +
                "    <author>Author 7</author>\n" +
                "    <title>Book 7</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk108\">\n" +
                "    <author>Author 8</author>\n" +
                "    <title>Book 8</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk109\">\n" +
                "    <author>Author 9</author>\n" +
                "    <title>Book 9</title>\n" +
                "  </book>\n" +
                "  <book id=\"bk110\">\n" +
                "    <author>Author 10</author>\n" +
                "    <title>Book 10</title>\n" +
                "  </book>\n" +
                "</catalog>\n";
        // Convert second XML string
        StringReader reader2 = new StringReader(xml2);
        XML.toJSONObject(reader2,
            jsonObj -> System.out.println("XML2 successfully converted:\n" + jsonObj.toString(2)),
            exception -> System.err.println("Error converting XML2: " + exception.getMessage())
        );
        // Convert first XML string
        StringReader reader1 = new StringReader(xml1);
        XML.toJSONObject(reader1, 
            jsonObj -> System.out.println("XML1 successfully converted:\n" + jsonObj.toString(2)),
            exception -> System.err.println("Error converting XML1: " + exception.getMessage())
        );
    }
}