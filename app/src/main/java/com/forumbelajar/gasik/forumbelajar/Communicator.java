package com.forumbelajar.gasik.forumbelajar;

/**
 * Created by Gasik on 6/7/2016.
 */
public interface Communicator {
    public void respond(String data);
    public void goTo(String data);
    public void createSession(String key,String Value);
    public String getSession();
}
