package com.Bookmap.App.enums;

public enum RecordType {
    UPDATE("u"),
    QUERY("q"),
    ORDER("o");

    public final String name;

    RecordType(String name){
        this.name=name;
    }
    public static RecordType valueOfName(String label) {
        for (RecordType e : values()) {
            if (e.name.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
