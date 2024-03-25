package com.hmproject.game;

import com.hmproject.design.Design;
import com.hmproject.hint.HintAlgo;
import com.hmproject.model.records.RecordTO;
import com.hmproject.wordselect.Word;

import java.util.Random;
import java.util.Scanner;

public class MainGame {

    public RecordTO launch() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Design design = new Design();

        RecordTO rto = new RecordTO();

        String[] words = Word.getWords(); // 첫번째 코드의 Word 클래스에서 단어 배열 받아오기
        String[] shortWords = new String[words.length];
        String[] longWords = new String[words.length];
        int shortIndex = 0;
        int longIndex = 0;
        int lives = 9;
        int hintCount = 0;

        // 단어를 길이에 따라 분류
        for (String word : words) {
            if (word.length() <= 6) {
                shortWords[shortIndex++] = word;
            } else {
                longWords[longIndex++] = word;
            }
        }

        System.out.println("---난이도 선택-------------------------------------------------------------------------------------------");
        System.out.print("1. 6자 이하\n2. 6자 초과\n");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.print("입력: ");

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

        design.GameStart();
        System.out.println("선택된 단어의 길이: " + word.length());
        System.out.println("게임 시작! 행맨을 살리고 싶다면 단어를 맞혀보세요.");

        rto.setDifficulty(difficulty);
        rto.setWord(word);
        int[] correct = new int[word.length()];
        char[] wArr = word.toCharArray();

        String[] displayArr = new String[wArr.length];

        String letters = "";
        rto.setStart(System.currentTimeMillis());

        while (true) {
            boolean succeed = true;

            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.print("알파벳이나 '힌트' 혹은 '탈출' 을 입력하세요. > ");
            String input = scanner.next();
            System.out.println("----------------------------------------------------------------------------------------------------------");
            if (input.equals("힌트")) {
                if (hintCount >= 1) {
                    System.out.println("힌트 횟수를 초과했습니다.");
                    continue;
                }
                String[] guessedLettersArr = new String[displayArr.length];
                for (int i = 0; i < displayArr.length; i++) {
                    if (displayArr[i] != null) {
                        guessedLettersArr[i] = displayArr[i];
                    } else {
                        guessedLettersArr[i] = "_";
                    }
                }
                HintAlgo.provideHint(guessedLettersArr, word, lives);
                design_man(lives);
                hintCount++;
                continue;
            } else if (input.equals("탈출")) {
                System.out.println("메인 화면으로 탈출합니다.");
                break;
            }

            String letter = String.valueOf(input.charAt(0));

            // 중복 입력 방지
            if (!letters.contains(letter)) {
                letters += letter;

                if (word.contains(letter)) {
                    System.out.println("맞았습니다! 행맨은 목숨을 잠깐이지만 부지하게 됐네요!");
                    design_man(lives);
                } else {
                    System.out.println("틀렸습니다. 행맨이 교수대에 매달리고 있어요!");
                    lives -= 1;
                    design_man(lives);
                }

                for(int i = 0; i < wArr.length; i++){
                    if (correct[i] == 1) {
                        System.out.print(wArr[i] + " ");
                        displayArr[i] = String.valueOf(wArr[i]);
                    } else if(wArr[i] == letter.charAt(0)){
                        correct[i]++;
                        System.out.print(wArr[i] + " ");
                        displayArr[i] = String.valueOf(wArr[i]);
                    } else {
                        System.out.print("_ ");
                        succeed = false;
                        displayArr[i] = "_";
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
                design.GameSuccess();
                System.out.println("정답입니다! 당신이 행맨을 살렸습니다!");
                break;
            }
            if (lives < 1) {
                design.StopHangman();
                System.out.println("행맨이 죽었습니다...");
                System.out.println("정답은 " + word + "였습니다!");
                break;
            }
        }

        return rto;
    }
    public void design_man(int life) {
        switch(life){
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

