package com.Bookmap.App.records;

import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.*;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class RecordsModelList {

    private static List<IRecordModel> recordModelList = new ArrayList<>();
    static {
        recordModelList.add(new UpdateBidModel());
        recordModelList.add(new UpdateAskModel());
        recordModelList.add(new QueryBestBidModel());
        recordModelList.add(new QueryBestAskModel());
        recordModelList.add(new QuerySizeModel());
    }

    public static IRecordModel getRecordModel(CSVRecord record) {

        String recordType = record.get(0);
        String name= "";

        switch(record.size()) {
            case 4: {
                name = record.get(3);
                break;
            }
            case 3:
            case 2: {
                name = record.get(1);
                break;
            }
            default: {
                name = record.get(1);
            }
        }

        String finalName = name;

        IRecordModel recordModel = recordModelList.stream()
                .filter(e->e.getRecordType()
                        .equals(RecordType.valueOfName(recordType, finalName)))
                .findFirst()
                .orElse(null);

        return recordModel;
    }



}
