package com.mechanitis.demo.sense.twitter;

public interface Parser {

    static String getTextFrom(String message) {
        return getValueForField("\"text\":\"", message);
    }

    static String getUsernameFromMessage(String message) {
        return getValueForField("\"screen_name\":\"", message);
    }

    static String getValueForField(String fieldName, String message) {
        final int indexOfFieldValue = message.indexOf(fieldName) + fieldName.length();
        final int indexOfEndOfFieldValue = message.indexOf("\"", indexOfFieldValue);
        return message.substring(indexOfFieldValue, indexOfEndOfFieldValue);
    }
}
