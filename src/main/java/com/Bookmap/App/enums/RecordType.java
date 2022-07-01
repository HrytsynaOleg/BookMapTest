package com.Bookmap.App.enums;

import org.apache.commons.csv.CSVRecord;

public enum RecordType {
    UPDATEBID("u","bid",3),
    UPDATEASK("u","ask",3),
    QUERYBESTBID("q","best_bid",1),
    QUERYBESTASK("q","best_ask",1),
    QUERYSIZE("q","size",1),
    ORDERBUY("o","buy",1),
    ORDERSELL("o","sell",1);

    public final String recordType;
    public final String name;
    public final int namePosition;


    RecordType(String recordType,String name, int namePosition){

        this.recordType =recordType;
        this.name =name;
        this.namePosition = namePosition;


    }
    public static RecordType valueOfName(String type, String name) {
        for (RecordType e : values()) {
            if (e.recordType.equals(type)&&(e.name.equals(name))) {
                return e;
            }
        }
        return null;
    }

    public static RecordType valueOfRecord(CSVRecord record) {

        for (RecordType e : values()) {

            if (record.size()-1<e.namePosition) continue;

            if (e.recordType.equals(record.get(0))&&(e.name.equals(record.get(e.namePosition)))) {
                return e;
            }
        }
        return null;
    }
}
