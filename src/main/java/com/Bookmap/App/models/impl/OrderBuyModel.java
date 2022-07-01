package com.Bookmap.App.models.impl;

import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OrderBuyModel implements IRecordModel {

    int size;

    public OrderBuyModel(int size) {
        this.size = size;
    }

    @Override
    public String performOperation(TreeMap<Integer, IRecordModel> recordsList) {


        Map.Entry entry = recordsList.entrySet().stream()
                .filter(e->e.getValue().getRecordType().equals(RecordType.UPDATEASK))
                .filter(e->((UpdateAskModel) e.getValue()).getSize()>0)
                .collect(Collectors.toMap(a->a.getKey(),b->b.getValue(),(o1, o2) -> o1,TreeMap::new))
                .firstEntry();

        int price = (int) entry.getKey();

        size=((UpdateAskModel) entry.getValue()).getSize()-size;

        if (size<0) size=0;

        UpdateAskModel model = new UpdateAskModel(price, size);
        recordsList.put(price,model);

    return "";
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.ORDERBUY;
    }
}
