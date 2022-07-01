package com.Bookmap.App.models.impl;

import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;

import java.util.TreeMap;


public class QuerySizeModel implements IRecordModel {

    private int price;

    public QuerySizeModel() {
    }

    public QuerySizeModel(int price) {
        this.price = price;
    }

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList) {

        if (recordsList.containsKey(Integer.valueOf(price))) {
            IRecordModel entry = recordsList.get(Integer.valueOf(price));
            switch (entry.getRecordType()) {
                case UPDATEBID: {
                    return String.valueOf(((UpdateBidModel) entry).getSize());
                }
                case UPDATEASK : {
                    return String.valueOf(((UpdateAskModel) entry).getSize());
                }
                default : {
                    return "0";
                }
            }

            }
        else {
            return "0";
        }
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.QUERYSIZE;
    }
}
