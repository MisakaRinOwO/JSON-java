# JSON in Java Overloaded Milestone 4
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.</br>
This project is done individually by Peter Xie.

# Overview
This library contains an overloaded toStream method for the JSONObject class.</br>

This overload allows users to chain operations on JSON nodes using stream methods.

# Feature
```java
JSONObject toJSONObject(Reader reader, Function<String, String> keyTransformer)
```

**Example**<br/>
Given the following JSONObject,
```json
{
  "Books": {
    "book": [
      {
        "title": "AAA",
        "author": "ASmith"
      },
      {
        "title": "BBB", 
        "author": "BSmith"
      }
    ]
  }
}
```
User can apply filter, map, and collect to the JSONObject stream to extract a list of node value which has "title" as key value:
```java
List<String> titles = obj.toStream().filter(node -> "title".equals(node.key))     // Filter node with key equals "title"
                                    .map(node -> node.value.toString())           // Getting value from nodes
                                    .collect(Collectors.toList());                // Collect as List<String>
```
Since nodes within an array will have the current path and index as key, for example:
```json
{
  "title": "AAA",
  "author": "ASmith"
}
```
has key equals "Books.book[0]", user can apply filter to exclude array indexies when collecting a set of keys presented in the JSONObject:
```java
Set<String> keys = obj.toStream().filter(node -> !node.key.contains("["))        // Filter node with non-array-index keys
                                 .map(node -> node.key.toString())               // Getting key from nodes
                                 .collect(Collectors.toSet());                   // Collect as List<String>
```
User can also use forEach to iterate over filtered node information, for example, print each node value where their value has a String type starting with letter A:</br>
(Note that node key, value, and path fields are final, meaning the user cannot make modification to node information.)
```java
obj.toStream().filter(node -> node.value instanceof String && ((String) node.value).startsWith("A"))
              .map(node -> node.value.toString())
              .forEach(System.out::println);                                     // Prints "AAA" and "ASmith"
```

# Implementation
This method leverages a custom JSONNodeSpliterator to provide a depth-first traversal of nested JSON structures (JSONObjects and JSONArrays). It converts each key-value pair into a JSONNode containing:

**key**: The property name (for objects) or array index as string (for arrays)<br/>
**value**: The actual data value<br/>
**path**: A dot-notation path string showing the hierarchical location (e.g., "address.street" or "books[0].title")<br/><br/>

The spliterator uses a stack-based approach with an ArrayDeque to manage traversal state, ensuring proper depth-first ordering while avoiding recursion stack overflow issues. Array elements are processed in reverse order (from highest to lowest index) to maintain correct sequential output when popped from the stack.<br/>

The resulting Stream<JSONNode> enables functional programming operations like filtering, mapping, and collecting on the entire JSON structure, making it efficient to search, transform, or analyze complex nested JSON data without manual recursive traversal.

# Usage
See the original [README.md](README.md)

# Additional Note
Changed gradle version to 8.5 in gradle\wrapper\gradle-wrapper.properties
for Java jdk 21 compatibility.
Original gradle version 6.3 only supports JDK up to version 14