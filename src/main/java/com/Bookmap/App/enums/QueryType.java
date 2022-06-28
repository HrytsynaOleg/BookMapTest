package com.Bookmap.App.enums;

public enum QueryType {
    BESTBID("best_bid"),
    BESTASK("best_ask"),
    SIZE("size");

    public final String name;

    QueryType(String name){
        this.name=name;
    }
    public static QueryType valueOfName(String label) {
        for (QueryType e : values()) {
            if (e.name.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
