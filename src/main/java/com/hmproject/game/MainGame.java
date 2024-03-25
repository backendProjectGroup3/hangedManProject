/*
package com.hmproject.game;

import com.hmproject.model.records.RecordTO;

import java.util.Random;
import java.util.Scanner;
//import game.HintClassName;

public class MainGame {

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

//            System.out.println(input.substring(0, 1));
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

            }else{
                System.out.println("이미 시도 한 문자입니다.");
                continue;
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
                rto.setHistory(letters.toCharArray());
                System.out.println("Success");
                break;
            }
        }

        return rto;
    }
}
*/

package com.hmproject.game;

import com.hmproject.model.records.RecordTO;
import com.hmproject.wordselect.Word;

import java.util.Random;
import java.util.Scanner;

public class MainGame {

    public RecordTO launch() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        RecordTO rto = new RecordTO();

        String[] words = Word.getWords(); // 첫번째 코드의 Word 클래스에서 단어 배열 받아오기
        String[] shortWords = new String[words.length];
        String[] longWords = new String[words.length];
        int shortIndex = 0;
        int longIndex = 0;
        int lives = 7;

        // 단어를 길이에 따라 분류
        for (String word : words) {
            if (word.length() <= 6) {
                shortWords[shortIndex++] = word;
            } else {
                longWords[longIndex++] = word;
            }
        }

        System.out.print("난이도 선택 (1: 6자 이하, 2: 6자 초과) : ");
        int difficulty = scanner.nextInt();
        String word;

        if (difficulty == 1) {
            word = shortWords[random.nextInt(shortIndex)];
        } else if (difficulty == 2) {
            word = longWords[random.nextInt(longIndex)];
        } else {
            System.out.println("올바른 난이도를 선택해주세요.");
            return null; // 올바르지 않은 입력일 경우 null 을 반환하거나 적절한 예외 처리를 수행할 수 있습니다.
        }

        System.out.println("선택된 단어의 길이: " + word.length());
        System.out.println("게임 시작! 단어를 맞혀보세요.");

        rto.setDifficulty(difficulty);
        rto.setWord(word);
        int[] correct = new int[word.length()];
        char[] wArr = word.toCharArray();

        String letters = "";
        rto.setStart(System.currentTimeMillis());

        while (true) {
            boolean succeed = true;

            System.out.println();

            System.out.print("Input letter or 'hint' > ");
            String input = scanner.next();
            if (input.equals("hint")) {
                // 힌트 기능 추가
                // HintClass.printHint();
                continue;
            }

            String letter = String.valueOf(input.charAt(0));

            // 중복 입력 방지
            if (!letters.contains(letter)) {
                letters += letter;

                if (word.contains(letter)) {
                    System.out.println("Correct");
                    design_man(lives);
                } else {
                    System.out.println("Wrong");
                    lives += -1;
                    design_man(lives);
                }

                for(int i = 0; i < wArr.length; i++){
                    if (correct[i] == 1) {
                        System.out.print(wArr[i] + " ");
                    } else if(wArr[i] == letter.charAt(0)){
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

            System.out.println();

            if (succeed) {
                rto.setEnd(System.currentTimeMillis());
                rto.setSolved(true);
                rto.setCorrect(correct);
                rto.setHistory(letters.toCharArray());
                System.out.println("Success");
                break;
            }
            if (lives < 1) {
                System.out.println("죽었습니다.");
                break;
            }
        }

        return rto;
    }
    public void design_man(int life) {
        switch(life){
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
                System.out.println(" -|     | ");
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
                System.out.println("  |     | ");
                System.out.println("-----   | ");
                break;
        }
    }
}

