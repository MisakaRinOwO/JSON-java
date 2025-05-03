# JSON in Java Overloaded
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.
This project is done by Peter Xie.

# Overview
This library contains an overloaded XML class, more specifically the parse method for XML.ToJSONObject.

This overload allows users to:
* add additional JSONPointer path as parameter of the XML.ToJSONObject to extract some smaller sub-object inside, given a JSONPointer. Unlike JSONPointer.queryFrom, this overloaded method returns a JSONObject, not the content.
* add additional JSONPointer and JSONObject parameter to replace a sub-object on a certain key path with another JSON object.

This feature is not supporting the customized XMLParserConfiguration parameter.

# Feature 1: 
**extract some smaller sub-object inside, given a JSONPointer**

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
This implementation saves time from the traditional method of using JSONPointer.queryFrom(XML.ToJSONObject) by terminating the recursion
when target object is found.

# Feature 2: 
**replace a sub-object on a certain key path with another JSON object, given a JSONPointer and a JSONObject**

```java
JSONObject toJSONObject(Reader reader, JSONPointer pointer, JSONObject replacement)
```

**Restriction**
Current implementation does not support indices within pointer path.

**Example**
Given the following XML file,
```xml
<contact>
  <nick>Anteater </nick>
  <name>Peter</name> 
  <address> 
    <street>UC Irvine</street> 
    <zipcode>92880</zipcode> 
  </address> 
</contact>
```

running on the above xml with pointer "contact/nick" and JSONObject {"nick":"Inserted Anteater"} will return
```json
{
  "contact": {
    "nick": "Inserted Anteater",
    "address": {
      "zipcode": 92880,
      "street": "UC Irvine"
    },
    "name": "Peter"
  }
}
```

running on the above xml with pointer and JSONObject containing JSONArray with pointer
```java
"contact/address" 
```
and JSONObject
```json
{
  "address": [
    {
      "zipcode": "zipcode insert 1",
      "street": "Address insert 1"
    },
    {
      "zipcode": "zipcode insert 2",
      "street": "Address insert 2"
    }
  ]
}
```
will return
```json
{
  "contact": {
    "nick": "Anteater",
    "address": [
      {
        "zipcode": "zipcode insert 1",
        "street": "Address insert 1"
      },
      {
        "zipcode": "zipcode insert 2",
        "street": "Address insert 2"
      }
    ],
    "name": "Peter"
  }
}
```

**Special Note**
running on the xml from feature 1 with pointer "catalog/book/author"
will replace every author found with the replacement object.

**Implementation and Performance**
This overloaded method uses a modified parse method to recursively build the JSONObject.
When recursion matches pointer path, a "canReplace" flag will be set to true and insert content of the replacement object with the matching key,
then the flag is sent to deeper recursions to prevent accumulation of the original XML content.
This implementation saves time from the traditional method of using JSONPointer.queryFrom(XML.ToJSONObject) by having the replacement done in only
one read-through of the XML content. 

# Additional Note
Changed gradle version to 8.5 in gradle\wrapper\gradle-wrapper.properties
for Java jdk 21 compatibility.
Original gradle version 6.3 only supports JDK up to version 14