package org.example;

import java.util.ArrayList;

public class Startup {
    private final String name;
    private ArrayList<String> location;

    public Startup(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public ArrayList<String> getLocation() {
        return location;
    }
}
