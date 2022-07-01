package com.Bookmap.App.models.impl;

import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import org.apache.commons.csv.CSVRecord;

import java.util.TreeMap;

public class UpdateBidModel implements IRecordModel {

    private int price;
    private int size;

    public UpdateBidModel() {}

    public UpdateBidModel(int price, int size) {
        this.price=price;
        this.size=size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList) {
//        UpdateBidModel model = new UpdateBidModel(Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2)));
        recordsList.put(price,this);
    return "";
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.UPDATEBID;
    }
}
