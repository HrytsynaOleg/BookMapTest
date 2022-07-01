package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.UpdateBidModel;
import org.apache.commons.csv.CSVRecord;

public class UpdateBidModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.UPDATEBID;
    }

    public IRecordModel buildModel(CSVRecord record) {
        return new UpdateBidModel(Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2)));
    }
}
