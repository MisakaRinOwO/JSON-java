# JSON in Java Overloaded Milestone 3
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.
This project is done by Peter Xie.

# Overview
This library contains an overloaded XML class, more specifically the parse method for XML.ToJSONObject.</br>
This Milestone is built on top of Milestone 2

This overload allows users to:
* add additional lambda function as parameter of the XML.ToJSONObject to perform transformation on keys.

This feature is not supporting the customized XMLParserConfiguration parameter.

# Feature: Replace key by transform function
```java
JSONObject toJSONObject(Reader reader, Function<String, String> keyTransformer)
```

**Example**<br/>
Given the following XML file,
```xml
<?xml version="1.0"?> 
<catalog>
  <book id="bk101">
    <author>Author 1</author>
    <title>Book 1</title>
  </book>
  <book id="bk102">
    <author>Author 2</author>
    <title>Book 2</title>
  </book>
</catalog>
```
valid keyTransformer could be:
```java
key -> "swe262_" + key
```
or
```java
key -> new StringBuilder(key).reverse().toString()
```
running on the above xml with keyTransformer "key -> "swe262_" + key" will prepend "swe262_" to all keys.
```json
{
  "swe262_catalog": {
    "swe262_book": [
      {
        "swe262_author": "Author 1",
        "swe262_id": "bk101",
        "swe262_title": "Book 1"
      },
      {
        "swe262_author": "Author 2",
        "swe262_id": "bk102",
        "swe262_title": "Book 2"
      }
    ]
  }
}
```

running on the above xml with keyTransformer "key -> new StringBuilder(key).reverse().toString()" will perform string reverse on original keys.
```json
{
  "golatac": {
    "koob": [
      {
        "rohtua": "Author 1",
        "di": "bk101",
        "eltit": "Book 1"
      },
      {
        "rohtua": "Author 2",
        "di": "bk102",
        "eltit": "Book 2"
      }
    ]
  }
}
```

**Implementation and Performance**<br/>
This overloaded method uses a modified parse method to perform transformation to tagName recursively.<br/>
This implementation performs keyTransformer.apply() to keys and config.getcDataTagName() found during the recursion to ensure to achieve the transformation.<br/>
This implementation saves time from the traditional method of creating new JSONObjects with modified key name and append content from the parsed JSONObject by performing transformation during the parse function.

# Usage
See the original [README.md](README.md)

# Additional Note
Changed gradle version to 8.5 in gradle\wrapper\gradle-wrapper.properties
for Java jdk 21 compatibility.
Original gradle version 6.3 only supports JDK up to version 14