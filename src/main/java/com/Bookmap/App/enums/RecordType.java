package com.Bookmap.App.enums;

public enum RecordType {
    UPDATEBID("u","bid"),
    UPDATEASK("u","bid"),
    QUERYBESTBID("q","best_bid"),
    QUERYBESTASK("q","best_ask"),
    QUERYSIZE("q","size"),
    ORDERBUY("o","buy"),
    ORDERSELL("o","sell");

    public final String recordType;
    public final String name;


    RecordType(String recordType,String name){

        this.recordType =recordType;
        this.name =name;


    }
    public static RecordType valueOfName(String type, String name) {
        for (RecordType e : values()) {
            if (e.recordType.equals(type)&&(e.name.equals(name))) {
                return e;
            }
        }
        return null;
    }
}
