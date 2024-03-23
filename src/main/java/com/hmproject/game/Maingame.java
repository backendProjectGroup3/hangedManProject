package com.hmproject.game;

import com.hmproject.model.records.RecordTO;

import java.util.Random;
import java.util.Scanner;
//import game.HintClassName;

public class Maingame {

    public RecordTO launch() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        RecordTO rto = new RecordTO();

        String[] words = {"apple", "banana", "orange"};
        String word = words[random.nextInt(words.length)];

        System.out.print("난이도 선택 : ");
        rto.setDifficulty(scanner.nextInt());
        rto.setWord(word);
        int[] correct = new int[word.length()];
        char[] wArr = word.toCharArray();


        System.out.println("answer : " + word);
        String letters = "";

        for(int i = 0; i < word.length(); i++){
            System.out.print("_ ");
        }

        rto.setStart(System.currentTimeMillis());
        while (true) {
            boolean succeed = true;

            System.out.println();

            System.out.print("Input letter or 'hint' > ");
            String input = scanner.next();
            if (input.equals("hint")) {

//                HintClass.printHint();
                continue;
            }

            String letter = String.valueOf(input.charAt(0));

            // 중복 입력 방지
            if (!letters.contains(letter)) {
                letters += letter;

                // 일치 여부 출력
                if (word.contains(letter)) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Wrong");
                }

            }else{
                System.out.println("이미 시도 한 문자입니다.");
                continue;
            }

            for(int i = 0; i < wArr.length; i++){
                if (correct[i] == 1) {                      // 이미 맞춘 문자 : 그대로 출력
                    System.out.print(wArr[i] + " ");

                } else if(wArr[i] == letter.charAt(0)){     // 입력한 문자가 i번째 문자와 일치 : correct[i]++로 맞춘 자리 표시 후 출력
                    correct[i]++;
                    System.out.print(wArr[i] + " ");

                }else{                                      // 마스킹 출력
                    System.out.print("_ ");
                    succeed = false;

                }
            }
//            for (char w : word.toCharArray()) {
//                if (letters.contains(String.valueOf(w))) {
//                    System.out.print(w + " ");
//                } else {
//                    System.out.print("_ ");
//                    succeed = false;
//                }
//            }
            System.out.println();

            if (succeed) {
                rto.setEnd(System.currentTimeMillis());
                rto.setSolved(true);
                rto.setCorrect(correct);
                rto.setIncorrect(letters.toCharArray());
                System.out.println("Success");
                break;
            }
        }

        return rto;
    }
}
