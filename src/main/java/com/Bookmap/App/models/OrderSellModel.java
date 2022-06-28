package com.Bookmap.App.models;

import com.Bookmap.App.enums.RecordType;
import org.apache.commons.csv.CSVRecord;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OrderSellModel implements IRecordModel{

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList, CSVRecord record) {

        int size = Integer.parseInt(record.get(2));

        Map.Entry entry = recordsList.entrySet().stream()
                .filter(e->e.getValue().getRecordType().equals(RecordType.UPDATEBID))
                .filter(e->((UpdateBidModel) e.getValue()).getSize()>0)
                .collect(Collectors.toMap(a->a.getKey(),b->b.getValue(),(o1, o2) -> o1,TreeMap::new))
                .lastEntry();

        int price = (int) entry.getKey();

        size=((UpdateBidModel) entry.getValue()).getSize()-size;

        if (size<0) size=0;

        UpdateBidModel model = new UpdateBidModel(price, size);
        recordsList.put(price,model);

    return "";
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.ORDERSELL;
    }
}
