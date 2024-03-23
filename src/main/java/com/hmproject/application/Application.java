package com.hmproject.application;

import com.hmproject.game.Maingame;
import com.hmproject.model.records.RecordDAO;
import com.hmproject.model.records.RecordTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Application {

    private static Maingame game;
    private static RecordDAO recordDAO;
    static{
        game = new Maingame();
        recordDAO = new RecordDAO();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<RecordTO> recordList = null;
        RecordTO result = null;

        int menu = 0;


        do{
            System.out.print("1. 플레이 / 2. 기록확인 / 9. 종료\n입력 : ");
            menu = sc.nextInt();

            switch(menu){
                case 1 :
                    result = game.launch();

                    int flag = recordDAO.registerRecord(result);
                    if(flag == 1){
                        System.out.println("게임 결과 등록에 실패했습니다.");
                    }
                    break;
                case 2 :
                    recordList = recordDAO.getList();
                    StringJoiner sb1 = new StringJoiner("\t\t");
                    StringJoiner sb2 = new StringJoiner("\t\t");

                    //
                    for(RecordTO record : recordList){
                        if(record.isSolved()){
                            sb1.add(record.getSeq() + "")
                                    .add(record.getDifficulty() + "")
                                    .add(record.getWord())
                                    .add(record.getTime())
                                    .add(record.getStime())
                                    .add(record.getEtime())
                                    .add(System.lineSeparator());
                        }else{
                            sb2.add(record.getSeq() + "")
                                    .add(record.getDifficulty() + "")
                                    .add(record.getWord())
                                    .add(record.getTime())
                                    .add(record.getStime())
                                    .add(record.getEtime())
                                    .add(System.lineSeparator());
                        }
                    }

                    if(sb1.length() != 0){
                        System.out.println("[성공]\n번호\t\t난이도\t단어\t\t소요시간\t\t시작시간\t\t\t\t\t종료시간");
                        System.out.println(sb1);
                    }
                    if(sb2.length() != 0){
                        System.out.println("[실패]\n번호\t\t난이도\t단어\t\t소요시간\t\t시작시간\t\t\t\t\t종료시간");
                        System.out.println(sb2);
                    }
                    break;
                case 9:
                    System.out.println("종료합니다.");
                    break;
                default :
                    System.out.println("올바른 번호를 입력하세요.");
            }

        }while(menu != 9);
    }
}
