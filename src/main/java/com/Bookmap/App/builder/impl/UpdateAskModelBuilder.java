package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.UpdateAskModel;
import org.apache.commons.csv.CSVRecord;

public class UpdateAskModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.UPDATEASK;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new UpdateAskModel(Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2)));
    }
}
