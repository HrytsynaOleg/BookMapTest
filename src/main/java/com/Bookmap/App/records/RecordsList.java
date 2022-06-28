package com.Bookmap.App.records;

import com.Bookmap.App.enums.OrderType;
import com.Bookmap.App.enums.QueryType;
import com.Bookmap.App.enums.UpdateType;
import org.apache.commons.csv.CSVRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RecordsList {

    private TreeMap<Integer,Integer> bidMap;
    private TreeMap<Integer,Integer> askMap;

    public RecordsList() {
        this.askMap = new TreeMap<>();
        this.bidMap = new TreeMap<>();
    }

    public void updateRecord(int price, int size, String updateRecordType) {

        switch (UpdateType.valueOf(updateRecordType)) {

           case BID: {
               bidMap.put(price,size);
               break;
           }
            case ASK:{
                askMap.put(price,size);
                break;
            }
        }
    }
    public void updateRecordByOrder(int size, String orderType) {
        switch (OrderType.valueOf(orderType)) {

            case BUY: {
                Map.Entry entry = askMap.firstEntry();
                askMap.put((Integer) entry.getKey(),(Integer) entry.getValue() - size);
                break;
            }
            case SELL:{
                Map.Entry entry = bidMap.lastEntry();
                bidMap.put((Integer) entry.getKey(),(Integer) entry.getValue() - size);
                break;
            }

        }

    }

    public String runQuery (CSVRecord query) {
        switch (QueryType.valueOfName(query.get(1))) {
            case BESTASK -> {
               return String.valueOf(askMap.firstEntry().getKey())+", "+ String.valueOf(askMap.firstEntry().getValue());
            }
            case BESTBID -> {
                return String.valueOf(bidMap.lastEntry().getKey())+", "+ String.valueOf(bidMap.lastEntry().getValue());
            }
            case SIZE -> {
                HashMap<Integer,Integer> newMap=new HashMap<Integer, Integer>(bidMap);
                newMap.putAll(askMap);

                if (newMap.containsKey(Integer.valueOf(query.get(2)))) {
                    String result = String.valueOf(newMap.get(Integer.valueOf(query.get(2))));
                    return result;
                } else return "0";

            }
        }

    return null;
    }



}
