# JSON in Java Overloaded Milestone 5
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.</br>
This project is done individually by Peter Xie.

# Overview
This library contains an overloaded toJSONObject method for the XML class.</br>

This overload method creates a new thread to handle the toJSONObject process in parallel to the main program, </br>
which allows the client code to proceed, while specifying what to do when the JSONObject becomes available.

# Feature
```java
XML.toJSONObject(aReader, (JSONObject jo) -> {jo.write(aWriter);}, (Exception e) -> {/* something went wrong */});
```

**Example**<br/>
Given the following client code,
```java
String xml1 = "<catalog>\n" +
              "  <book id=\"bk101\">\n" +
              "    <author>Author 1</author>\n" +
              "    <title>Book 1</title>\n" +
              "  </book>\n" +
              "</catalog>\n";

StringReader reader1 = new StringReader(xml1);

XML.toJSONObject(reader1, 
    jsonObj -> {
        System.out.println("XML1 successfully converted:\n" + jsonObj.toString(2));
    },
    exception -> {
        System.err.println("Error converting XML1: " + exception.getMessage());
    }
);

// Process other task without waiting for toJSONObject to finish
```
xml1 are submitted to the shared threadpool in XML class to handle JSONObject convertion, </br>
and other tasks can be performed at the same time while waiting for the process to complete.

The user will need to use a latch to ensure callbacks are completed before proceeding to handle </br>
callback objects in the client code.

```java
CountDownLatch latch = new CountDownLatch(numProcess);

// ... create StringReader

XML.toJSONObject(reader1, 
    jsonObj -> {
        System.out.println("XML1 successfully converted:\n" + jsonObj.toString(2));
        latch.countDown();
    },
    exception -> {
        System.err.println("Error converting XML1: " + exception.getMessage());
        latch.countDown();
    }
);

// Ensure all callbacks are finished
latch.await(10, TimeUnit.SECONDS);

// Process callback objects
```

The user can also use latch to wait for all threads to finish befor proceeding
```java
long startTime = System.currentTimeMillis();
while (XML.activeTasks.get() > 0 && (System.currentTimeMillis() - startTime) < 5000) {
    Thread.sleep(50);
}
```

Before client code exits, the user can choose to manually cleanup the XML executor after all threads finish.

```java
XML.shutdownAsyncExecutor();
```

# Implementation
This implementation extended the XML class by adding a class level shared thread pool, an overloaded toJSONObject for async, and a shutdown method.</br>
The async toJSONObject method takes a StringReader, a Consumer\<JSONObject>, and a Consumer\<Exception> as parameter.</br>
It submits a new process to use basic toJSONObject method and what to do with the Consumers after success or catching exception to the shared executor. </br>
It also modifies the class level activeTasks indicator when tasks are submitted and finished.


# Usage
See the original [README.md](README.md)

# Additional Note
Changed gradle version to 8.5 in gradle\wrapper\gradle-wrapper.properties
for Java jdk 21 compatibility.
Original gradle version 6.3 only supports JDK up to version 14