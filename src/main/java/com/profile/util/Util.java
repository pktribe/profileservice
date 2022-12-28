package com.profile.util;

import java.util.UUID;

public class Util {

    private Util(){
        //empty private constructor 
    }
    public static String generateRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
