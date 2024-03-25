package com.hmproject.model.records;

import com.hmproject.repository.RecordRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecordDAO {

    private RecordRepository rp;

    public RecordDAO(){
        rp = new RecordRepository();
    }

    public ArrayList<RecordTO> getList(){
        return rp.selectAll();
    }

    public RecordTO getRecord(int seq){
        RecordTO data = rp.select(seq - 1);

        return data;
    }

    public int registerRecord(RecordTO rto){
        int flag = 1;

        String stime = "", etime = "", time = "";

        long start = rto.getStart(), end = rto.getEnd(), duration = end - start;
        long minute = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        stime = sdf.format( new Date(start) );
        etime = sdf.format( new Date(end) );

        rto.setStime(stime);
        rto.setEtime(etime);

        duration /= 1000;
        if((minute = duration / 60) > 0) {
            time = minute + "m " + (duration % 60) + "s";

        }else{
            time = duration >= 10 ? duration + "s" : "0" + duration + "s";

        }
        rto.setTime(time);

        if(rp.insert(rto)){
            flag = 0;
        }
        return flag;
    }
}
