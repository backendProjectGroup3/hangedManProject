package com.hmproject.repository;

import com.hmproject.model.records.RecordTO;

import java.util.ArrayList;

public class RecordRepository {
    private static ArrayList<ArrayList<RecordTO>> recordPerMember;
    static{
        recordPerMember = new ArrayList<>();
    }

    private ArrayList<RecordTO> recordList;
    private int listSeq;

    public RecordRepository(){
        this.recordList = new ArrayList<>();

        RecordRepository.recordPerMember.add(recordList);
        this.listSeq = RecordRepository.recordPerMember.size();
    }

    // 기록 전체 출력
    public ArrayList<RecordTO> select(){
        return recordList;
    }

    // 기록 한 개 선택
    public RecordTO select(int seq){
        return recordList.get(seq);
    }

    // 기록 입력
    public boolean insert(RecordTO rto){

        return recordList.add(rto);
    }

    // 기록 삭제
    public boolean delete(int seq){

        return recordList.remove(seq) != null;
    }
}
