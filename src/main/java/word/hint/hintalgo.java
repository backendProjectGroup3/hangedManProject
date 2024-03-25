package word.hint;

public class hintalgo {


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
            System.out.println("I can't give you a hint");
            return;
        }
        if(emptyCount >= 3 && lives > 1) {
            ch = word.charAt(emptyIndex);
        }

        System.out.println("hint: " + emptyIndex + " index is " + ch
        );



    }

}
