package game;

import java.util.Random;
import java.util.Scanner;

public class Maingame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "banana", "orange"};
        String word = words[random.nextInt(words.length)];

        System.out.println("answer : " + word);

        String letters = "";

        while (true) {
            boolean succeed = true;

            System.out.println();

            for (char w : word.toCharArray()) {
                if (letters.contains(String.valueOf(w))) {
                    System.out.print(w + " ");
                } else {
                    System.out.print("_ ");
                    succeed = false;
                }
            }
            System.out.println();

            if (succeed) {
                System.out.println("Success");
                break;
            }

            System.out.print("Input letter > ");
            String letter = scanner.next();

            if (!letters.contains(letter)) {
                letters += letter;
            }

            if (word.contains(letter)) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
            }
        }
    }
}
