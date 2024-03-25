package com.hmproject.hint;

public class HintAlgo {


    public static void provideHint(String[] guessedLetters, String word, int lives){

        int emptyCount = 0;

        int emptyIndex =-1;

        char ch = '\0';


        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i].equals("_")) {
                if(emptyCount==0){
                    emptyIndex=i;
                }
                emptyCount++;

            }
        }
        if (emptyCount <3 || lives <= 1) {
            System.out.println("빈 알파벳 갯수가 3개도 안남았거나 \n목숨이 하나밖에 남지 않았군요? \n아쉽게도 힌트는 제공할 수 없습니다.");
            return;
        }
        if(emptyCount >= 3 && lives > 1) {
            ch = word.charAt(emptyIndex);
        }

        System.out.println("힌트를 알려드리죠! " + (emptyIndex + 1) + " 번째 알파벳은 " + ch + "입니다!");

    }

}
