package com.Bookmap.App.builder;

import com.Bookmap.App.builder.impl.*;
import com.Bookmap.App.enums.RecordType;

import java.util.ArrayList;
import java.util.List;

public class RecordModelBuilderFactory {

    private static List<IRecordModelBuilder> builders = new ArrayList<>();
    static {
        builders.add(new UpdateBidModelBuilder());
        builders.add(new UpdateAskModelBuilder());
        builders.add(new QueryBestBidModelBuilder());
        builders.add(new QueryBestAskModelBuilder());
        builders.add(new QuerySizeModelBuilder());
        builders.add(new OrderSellModelBuilder());
        builders.add(new OrderBuyModelBuilder());
    }

    public static IRecordModelBuilder gerBuilder(RecordType recordType) {

        return builders.stream()
                .filter(e->e.getBuilderType().equals(recordType))
                .findFirst()
                .orElse(null);
    }


}
