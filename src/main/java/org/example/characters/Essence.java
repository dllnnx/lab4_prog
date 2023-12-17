package org.example.characters;

public abstract class Essence {
    private  String name;

    public Essence(String name) {
        this.name = name;
    }

    public Essence() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
