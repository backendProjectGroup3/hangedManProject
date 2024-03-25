package com.hmproject.wordselect;

public class Word {
    public static String[] getWords(){
        return new String[]{"apple", "banana", "orange", "watermelon", "pineapple", "grape",
                "strawberry", "blueberry", "blackberry", "cantaloupe", "kiwifruit",
                "peach", "plum", "pear", "cherry", "melon", "fig", "date", "kiwi",
                "avocado", "coconut", "lime", "mango", "papaya", "lychee", "durian",
                "apricot", "tangerine", "cranberry", "nectarine", "guava", "grapefruit",
                "boysenberry", "dragonfruit", "persimmon", "pomegranate", "rhubarb",
                "jackfruit", "lemon", "lime", "mango", "banana", "peach", "plum",
                "pear", "cherry", "grape","Serendipity","Ephemeral","Obfuscate"};

/*
        String[] longWords = new String[words.length];
        String[] shortWords = new String[words.length];

        int longIndex = 0;
        int shortIndex = 0;


        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 6) {
                longWords[longIndex++] = word;
            } else {
                shortWords[shortIndex++] = word;
            }
        }

        System.out.println("6>WORD");
        for (int i = 0; i < longIndex; i++) {
            System.out.print(longWords[i]+",");

        }
        System.out.println();


        System.out.println("6<WORD");
        for (int i = 0; i < shortIndex; i++) {
            System.out.print(shortWords[i]+",");
        }
*/

    }

}
