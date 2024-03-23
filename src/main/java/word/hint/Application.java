package word.hint;

public class Application {


    public static void main(String[] args) {

        String[] guessedLetters = {"_", "x", "_", "m", "_", "_", "e"};

        String word = "example";


        int lives = 2;

        hintalgo hintprovide= new hintalgo();
        hintprovide.provideHint(guessedLetters, word, lives);
    }
}
