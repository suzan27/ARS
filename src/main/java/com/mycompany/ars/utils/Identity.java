package com.mycompany.ars.utils;

/**
 *
 * @author bikesh
 */
public class Identity {

    public static final String SESSION_KEY = "my.security";
    private final String username;

    public static Identity createDefaultInstacne() {
        return new Identity("");
    }

    public Identity(String username) {
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

}
