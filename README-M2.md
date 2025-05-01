# JSON in Java Overloaded
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.
This project is done by Peter Xie.

# Overview
This library contains an overloaded XML class, more specifically the parse method for XML.ToJSONObject.

This overload allows users to:
* add additional JSONPointer path as parameter of the XML.ToJSONObject to extract some smaller sub-object inside, given a JSONPointer. Unlike JSONPointer.queryFrom, this overloaded method returns a JSONObject, not the content.
* add additional JSONPointer and JSONObject parameter to replace a sub-object on a certain key path with another JSON object.

This feature is not supporting the customized XMLParserConfiguration parameter.

# Features
1. extract some smaller sub-object inside, given a JSONPointer.
```java
JSONObject toJSONObject(Reader reader, JSONPointer pointer)
```

**Restriction**
Current implementation does not support indices within pointer path.

**Example**
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
valid pointer path could be:
```java
"catalog"
"catalog/book"
"catalog/book/author"
```

running on the above xml with pointer "catalog/book" will only return the first book object found.
```json
{"book":{"author":"Author 1","id":"bk101","title":"Book 1"}} 
```

running on the above xml with pointer "catalog/book/author" will only return the author for the first book object found.
```json
{"author":"Author 1"}
```

**Implementation and Performance**
This overloaded method uses a modified parse method to recursively build the JSONObject when reaching elements with tagname matching the pointer path.
This implementation parses when first key matching the pointer path is found and terminates to return the constructed JSONObject.
This implementation saves time from the traditional method of using JSONPointer.queryFrom(XML.ToJSONObject). 


# Additional Note
Changed gradle version to 8.5 in gradle\wrapper\gradle-wrapper.properties
for Java jdk 21 compatibility.
Original gradle version 6.3 only supports JDK up to version 14