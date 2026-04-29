package com.notification.util;
 
public class NotificationSimulator {
 
    public static boolean send(String type, String message) {
        System.out.println("Sending " + type + ": " + message);
        return true;
    }
}