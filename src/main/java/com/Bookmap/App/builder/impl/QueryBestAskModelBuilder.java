package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.QueryBestAskModel;
import org.apache.commons.csv.CSVRecord;

public class QueryBestAskModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.QUERYBESTASK;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new QueryBestAskModel();
    }
}
