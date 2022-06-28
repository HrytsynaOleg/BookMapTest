package com.Bookmap.App.models;

import com.Bookmap.App.enums.RecordType;
import org.apache.commons.csv.CSVRecord;
import java.util.TreeMap;


public class QuerySizeModel implements IRecordModel{

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList, CSVRecord record) {

        if (recordsList.containsKey(Integer.valueOf(record.get(2)))) {
            IRecordModel entry = recordsList.get(Integer.valueOf(record.get(2)));
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
