package com.joonseolee.springsecuritytutorial.domain;

public class HandWritten {

    public String toRole(String address) throws Exception {
        if (address == null)
            throw new Exception("Somebody help!");

        if (address.length() > 10)
            throw new Exception("Hi there.");

        return address;
    }
}
