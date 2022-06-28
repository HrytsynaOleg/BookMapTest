package com.Bookmap.App.models;

import com.Bookmap.App.enums.RecordType;
import org.apache.commons.csv.CSVRecord;

import java.util.TreeMap;

public class UpdateAskModel implements IRecordModel{

    private int price;
    private int size;

    public UpdateAskModel() {}

    public UpdateAskModel(int price, int size) {
        this.price=price;
        this.size=size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList, CSVRecord record) {
        UpdateAskModel model = new UpdateAskModel(Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2)));
        recordsList.put(Integer.parseInt(record.get(1)),model);
    return "";
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.UPDATEASK;
    }
}
