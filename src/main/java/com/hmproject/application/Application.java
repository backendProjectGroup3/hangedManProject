package com.hmproject.application;

import com.hmproject.game.MainGame;
import com.hmproject.model.records.RecordDAO;
import com.hmproject.model.records.RecordTO;
import com.hmproject.model.records.RecordView;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RecordView recordView = null;
        ArrayList<RecordTO> recordList = null;
        RecordTO record = null;

        int menu = 0;

        MainGame game = new MainGame();
        RecordDAO recordDAO = new RecordDAO();

        do{
            System.out.print("1. 플레이 / 2. 기록확인 / 3. 종료\n입력 : ");
            menu = sc.nextInt();

            switch(menu){
                case 1 :
                    record = game.launch();

                    int flag = recordDAO.registerRecord(record);
                    if(flag == 1){
                        System.out.println("게임 결과 등록에 실패했습니다.");
                    }
                    break;
                case 2 :
                    recordList = recordDAO.getList();

                    recordView = new RecordView(recordList);
                    recordView.viewList();

                    break;
                case 3:
                    System.out.println("종료합니다.");
                    break;
                default :
                    System.out.println("올바른 번호를 입력하세요.");
            }

        }while(menu != 3);
        sc.close();
    }
}
