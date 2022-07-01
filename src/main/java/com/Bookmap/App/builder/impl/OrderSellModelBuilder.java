package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.OrderSellModel;
import org.apache.commons.csv.CSVRecord;

public class OrderSellModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.ORDERSELL;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new OrderSellModel(Integer.parseInt(record.get(2)));
    }
}
