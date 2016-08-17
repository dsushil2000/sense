package com.mechanitis.demo.sense.twitter;

public interface Parser {

    static String getValueFromMessage(String message, String fieldName) {
        final int indexOfFieldValue = message.indexOf(fieldName) + fieldName.length();
        final int indexOfEndOfFieldValue = message.indexOf("\"", indexOfFieldValue);
        return message.substring(indexOfFieldValue, indexOfEndOfFieldValue);
    }

}
