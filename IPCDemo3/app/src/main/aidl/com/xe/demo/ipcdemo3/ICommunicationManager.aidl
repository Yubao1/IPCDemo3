// ICommunicationManager.aidl
package com.xe.demo.ipcdemo3;

// Declare any non-default types here with import statements

interface ICommunicationManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            void sendMessage(in String msg);
}
