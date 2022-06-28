package com.Bookmap.App.models;

import com.Bookmap.App.enums.RecordType;
import org.apache.commons.csv.CSVRecord;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class QueryBestAskModel implements IRecordModel{

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList, CSVRecord record) {

        Map.Entry entry = recordsList.entrySet().stream()
                .filter(e->e.getValue().getRecordType().equals(RecordType.UPDATEASK))
                .collect(Collectors.toMap(a->a.getKey(),b->b.getValue(),(o1, o2) -> o1,TreeMap::new))
                .firstEntry();

    return entry.getKey()+", "+ ((UpdateBidModel) entry.getValue()).getSize();
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.QUERYBESTASK;
    }
}
