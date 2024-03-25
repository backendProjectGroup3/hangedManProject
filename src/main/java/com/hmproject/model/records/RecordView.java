package com.hmproject.model.records;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

public class RecordView {
    private ArrayList<RecordTO> recordList;

    public RecordView(ArrayList<RecordTO> recordList) {
        this.recordList = recordList;
    }

    // 기록 전체 출력
    public void viewList(){

        if (!recordList.isEmpty()) {
            Scanner sc = new Scanner(System.in);

            StringJoiner sj1 = new StringJoiner("\t\t");
            StringJoiner sj2 = new StringJoiner("\t\t");

            int option = 0;

            //
            for(RecordTO record : recordList){
                if(record.isSolved()){
                    sj1.add(record.getSeq() + "")
                            .add(record.getDifficulty() + "")
                            .add(record.getWord())
                            .add(record.getTime())
                            .add(record.getStime())
                            .add(record.getEtime())
                            .add(System.lineSeparator());
                }else{
                    sj2.add(record.getSeq() + "")
                            .add(record.getDifficulty() + "")
                            .add(record.getWord())
                            .add(record.getTime())
                            .add(record.getStime())
                            .add(record.getEtime())
                            .add(System.lineSeparator());
                }
            }
            System.out.println("--------------------------------------------------------------------");
            if(sj1.length() != 0){
                System.out.println("[성공]\n번호\t\t난이도\t단어\t\t소요시간\t\t시작시간\t\t\t\t\t종료시간");
                System.out.println(sj1);
            }
            if(sj2.length() != 0){
                System.out.println("[실패]\n번호\t\t난이도\t단어\t\t소요시간\t\t시작시간\t\t\t\t\t종료시간");
                System.out.println(sj2);
            }
            System.out.println("--------------------------------------------------------------------");

            do{
                System.out.print("1. 세부기록 조회\t9. 뒤로가기\n> ");

                try {
                    option = Integer.parseInt(sc.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("올바른 번호를 입력하세요.");
                    continue;

                }

                switch(option) {
                    case 1:
                        do {
                            System.out.print("조회할 기록의 번호를 입력(취소: 숫자가 아닌 문자)\n> ");
                            try {
                                option = Integer.parseInt(sc.nextLine());

                                viewRecord(option);

                            } catch (NumberFormatException e) {
                                option = -1;
                                break;
                            }

                        } while (option != -1);
                        break;

                    case 9:
                        break;

                    default:
                        System.out.println("올바른 번호를 입력하세요.");
                }

            }while(option != 9);

        }else{
            System.out.println("기록이 존재하지 않습니다.");
        }
    }

    public void viewRecord(int seq){
        System.out.println("--------------------------------------------------------------------");
        try {
            RecordTO record = recordList.get(seq - 1);

            for(char ch : record.getHistory()){
                System.out.println(ch);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("입력하신 번호의 기록이 존재하지 않습니다.");
        }
        System.out.println("--------------------------------------------------------------------");
    }
}
