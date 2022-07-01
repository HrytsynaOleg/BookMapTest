package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.OrderBuyModel;
import org.apache.commons.csv.CSVRecord;

public class OrderBuyModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.ORDERBUY;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new OrderBuyModel(Integer.parseInt(record.get(2)));
    }
}
