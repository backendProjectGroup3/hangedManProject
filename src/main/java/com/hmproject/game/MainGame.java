package com.hmproject.game;

import com.hmproject.design.Design;
import com.hmproject.hint.Hint;
import com.hmproject.model.records.RecordTO;
import com.hmproject.repository.WordRepository;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

    public RecordTO launch() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Design design = new Design();

        RecordTO rto = new RecordTO();

        int lives = 9;
        int hintCount = 0;

        int[] correct = null;
        ArrayList<String> history = null;

        int difficulty = 0;
        String word = "";
        do{
            System.out.println("---난이도 선택-------------------------------------------------------------------------------------------");
            System.out.print("1. 6자 이하\n2. 6자 초과\n");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.print("입력: ");
            difficulty = Integer.parseInt(scanner.nextLine());


            if (difficulty == 1) {
                word = WordRepository.selectNormal();
            } else if (difficulty == 2) {
                word = WordRepository.selectHard();
            } else {
                System.out.println("올바른 난이도를 선택해주세요.");
            }
        }while(difficulty != 1 && difficulty != 2);

        design.GameStart();
        System.out.println("선택된 단어의 길이: " + word.length());
        System.out.println("게임 시작! 행맨을 살리고 싶다면 단어를 맞혀보세요.");

        correct = new int[word.length()];
        history = new ArrayList<>();

        char[] wArr = word.toCharArray();

        boolean succeed = false;
        // 게임 시작
        rto.setStart(System.currentTimeMillis());
        do {

            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.print("알파벳을 입력하세요.(정답유추 : 'try' / 힌트사용: 'hint' / 중도포기: 'escape')");
            System.out.print("\n남은 목숨 : " + lives);
            if(!history.isEmpty()){
                System.out.print("\t\t입력 현황 : ");
                for(String tmp : history){
                    System.out.print(tmp + " ");
                }
            }
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();
            System.out.println("----------------------------------------------------------------------------------------------------------");

            if(input.equals("try")){
                System.out.print("경고! 신중하게 입력하세요! (영문 외 문자열이나 중복 입력에 대한 추가 기회가 없습니다.)\n> ");
                input = scanner.nextLine().toLowerCase();

                history.add(input);

                if(word.equals(input)){
                    rto.setEnd(System.currentTimeMillis());
                    succeed = true;
                }else {
                    System.out.println("틀렸습니다. 행맨이 교수대에 매달리고 있어요!");
                    lives -= 1;
                }

            }else if (input.equals("hint")) {
                if (hintCount >= 1) {
                    System.out.println("힌트 횟수를 초과했습니다.");
                    continue;
                }

                Hint.provideHint(correct, wArr, lives);
                hintCount++;
                continue;

            } else if (input.equals("escape")) {

                System.out.println("메인 화면으로 탈출합니다.");
                break;

            }else{
                char charLetter = input.charAt(0);

                // 알파벳 입력 검사
                if(97 <= charLetter && charLetter <= 122){
                    String strLetter = String.valueOf(charLetter);

                    // 중복 입력 방지
                    if (!history.contains(strLetter)) {
                        history.add(strLetter);

                        if (word.contains(strLetter)) {
                            System.out.println("맞았습니다! 행맨은 목숨을 잠깐이지만 부지하게 됐네요!");
                            design_man(lives);
                        } else {
                            System.out.println("틀렸습니다. 행맨이 교수대에 매달리고 있어요!");
                            lives -= 1;
                            design_man(lives);
                        }
                        succeed = true;
                        for(int i = 0; i < wArr.length; i++){
                            if (correct[i] == 1) {
                                System.out.print(wArr[i] + " ");

                            } else if(wArr[i] == strLetter.charAt(0)){
                                correct[i]++;
                                System.out.print(wArr[i] + " ");

                            } else {
                                System.out.print("_ ");
                                succeed = false;
                            }
                        }
                    } else {
                        System.out.println("이미 시도한 문자입니다.");
                        continue;
                    }
                }else{
                    System.out.println("알파벳을 입력해주세요.");
                    continue;
                }

                System.out.println();
            }

            if(succeed){
                design.GameSuccess();
                System.out.println("정답입니다! 당신이 행맨을 살렸습니다!");

            }
            if (lives < 1) {
                design.StopHangman();
                System.out.println("행맨이 죽었습니다...");
                System.out.println("정답은 " + word + "였습니다!");
                break;
            }
        }while(!succeed);
        rto.setEnd(System.currentTimeMillis());
        rto.setSolved(succeed);
        rto.setDifficulty(difficulty);
        rto.setWord(word);
        rto.setCorrect(correct);
        rto.setHistory(history.toArray(new String[0]));

        return rto;
    }


    public void design_man(int life) {
        switch(life){
            case 9:
                System.out.println("  _______ ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                break;

            case 8:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                break;
            case 7:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("        | ");
                System.out.println("        | ");
                System.out.println("        | ");
                break;
            case 6:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("        | ");
                System.out.println("        | ");
                break;
            case 5:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("  |     | ");
                System.out.println("        | ");
                break;
            case 4:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("--|     | ");
                System.out.println("        | ");
                break;
            case 3:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("--|--   | ");
                System.out.println("        | ");
                break;
            case 2:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("--|--   | ");
                System.out.println("  |     | ");
                break;
            case 1:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("--|--   | ");
                System.out.println("__|     | ");
                break;
            case 0:
                System.out.println("  _______ ");
                System.out.println("  |     | ");
                System.out.println("  |     | ");
                System.out.println("  ●     | ");
                System.out.println("--|--   | ");
                System.out.println("__|__   | ");
                break;
        }
    }
}

