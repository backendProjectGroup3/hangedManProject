package com.hmproject.model.records;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordTO {

    private int seq;
    private int difficulty;
    private String word;
    private int[] correct;
    private char[] history;
    private String time;
    private String stime;
    private String etime;
    private long start;
    private long end;
    private boolean isSolved;

}
