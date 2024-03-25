package com.hmproject.repository;

import com.hmproject.model.records.RecordTO;

import java.util.ArrayList;

public class RecordRepository {
    private static final ArrayList<RecordTO> RECORD_LIST;
    static{
        RECORD_LIST = new ArrayList<>();
    }

    // 기록 전체 출력
    public ArrayList<RecordTO> selectAll(){

        return RECORD_LIST;
    }

    // 기록 한 개 선택
    public RecordTO select(int seq){

        try {
            return RECORD_LIST.get(seq);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // 기록 입력
    public boolean insert(RecordTO rto){

        rto.setSeq(RECORD_LIST.size() + 1);
        return RECORD_LIST.add(rto);
    }

    // 기록 삭제
//    public boolean delete(int seq){
//
//        return RECORD_LIST.remove(seq) != null;
//    }
}
