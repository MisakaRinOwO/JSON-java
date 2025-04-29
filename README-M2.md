# JSON in Java Overloaded
This is an overloaded version of the original JSON library for SWE 262P Programming Styles at UC Irvine's Master of Software Engineering program.
This project is done by Peter Xie.

# Overview
This library contains an overloaded XML class, more specifically the parse method for XML.ToJSONObject.

This overload allows users to:
* add additional JSONPointer path as parameter of the XML.ToJSONObject
* add additional boolean mode as parameter of the XML.ToJSONObject

Overloaded XML.ToJSONObject must take the two additional parameters together.
This feature is not supporting the customized XMLParserConfiguration parameter.

# Functionality
**Mode flag 0 allows the XML.ToJSONObject to return the JSONObject based on JSONPointer path**

Unlike JSONPointer.queryFrom, this overloaded method only returns a JSONObject given the pointer path.

WIP...