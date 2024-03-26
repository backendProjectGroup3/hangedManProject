package com.hmproject.model.records;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class RecordView {
    private ArrayList<RecordTO> recordList;

    // 기록 전체 출력
    public void viewList(ArrayList<RecordTO> recordList){
        this.recordList = recordList;

        if (!this.recordList.isEmpty()) {
            Scanner sc = new Scanner(System.in);

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            StringJoiner sj = new StringJoiner("\t\t");

            int option = 0;

            //
            for(RecordTO record : this.recordList){
                if(record.isSolved()){
                    sj.add(record.getSeq() + "")
                            .add(record.getDifficulty() + "")
                            .add(record.getWord())
                            .add(record.getTime())
                            .add(record.getStime())
                            .add(record.getEtime())
                            .add(System.lineSeparator());
                    sb1.append(sj);
                    sj = new StringJoiner("\t\t");

                }else{
                    sj.add(record.getSeq() + "")
                            .add(record.getDifficulty() + "")
                            .add(record.getWord())
                            .add(record.getTime())
                            .add(record.getStime())
                            .add(record.getEtime())
                            .add(System.lineSeparator());
                    sb2.append(sj);
                    sj = new StringJoiner("\t\t");
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
            if(!sb1.isEmpty()){
                System.out.println("[성공]\n번호\t난이도\t단어\t소요시간\t 시작시간\t\t\t     종료시간");
                System.out.println(sb1);
            }
            if(!sb2.isEmpty()){
                System.out.println("[실패]\n번호\t난이도\t단어\t소요시간\t 시작시간\t\t\t     종료시간");
                System.out.println(sb2);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
            do{
                System.out.print("1. 세부기록 조회\n9. 뒤로가기\n");
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.print("입력: ");
                try {
                    option = Integer.parseInt(sc.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("올바른 번호를 입력하세요.");
                    continue;

                }

                switch(option) {
                    case 1:
                        do {
                            System.out.println("----------------------------------------------------------------------------------------------------------");
                            System.out.println("조회할 기록의 번호를 입력(취소: 숫자가 아닌 문자)");
                            System.out.println("----------------------------------------------------------------------------------------------------------");
                            System.out.print("입력: ");
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
        System.out.println("----------------------------------------------------------------------------------------------------------");
        try {
            RecordTO record = recordList.get(seq - 1);

            for(String str : record.getHistory()){
                System.out.println(str);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("입력하신 번호의 기록이 존재하지 않습니다.");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }
}
