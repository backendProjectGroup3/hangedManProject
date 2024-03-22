package com.hmproject.model.records;

import java.util.ArrayList;

public class RecordRepository {
    private static ArrayList<RecordTO> recordList;

    static {
        recordList = new ArrayList<RecordTO>();
    }

    public static ArrayList<RecordTO> select(){
        return recordList;
    }

    public static RecordTO select(int seq){
        return recordList.get(seq);
    }

    public static boolean insert(RecordTO rto){

        return recordList.add(rto);
    }


}
