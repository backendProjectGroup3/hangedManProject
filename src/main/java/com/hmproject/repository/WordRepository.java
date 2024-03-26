package com.hmproject.repository;

import java.util.Random;

public class WordRepository {

    private static final String[] words;
    private static final String[] normal;
    private static final String[] hard;
    static {
        words = new String[]{"apple", "banana", "orange", "watermelon", "pineapple", "grape",
                "strawberry", "blueberry", "blackberry", "cantaloupe", "kiwifruit",
                "peach", "plum", "pear", "cherry", "melon", "fig", "date", "kiwi",
                "avocado", "coconut", "lime", "mango", "papaya", "lychee", "durian",
                "apricot", "tangerine", "cranberry", "nectarine", "guava", "grapefruit",
                "boysenberry", "dragonfruit", "persimmon", "pomegranate", "rhubarb",
                "jackfruit", "lemon", "lime", "mango", "banana", "peach", "plum",
                "pear", "cherry", "grape", "Serendipity", "Ephemeral", "Obfuscate"};

        normal = new String[]{"apple", "banana", "orange", "grape", "peach", "plum", "pear",
                "melon", "fig", "date", "kiwi", "lime", "mango", "papaya", "lychee", "durian",
                "guava", "lemon", "lime", "mango"};

        hard = new String[]{"watermelon", "pineapple", "strawberry", "blueberry", "blackberry",
            "cantaloupe", "kiwifruit", "avocado","coconut", "apricot", "tangerine", "cranberry", "nectarine",
            "grapefruit", "boysenberry", "dragonfruit", "persimmon", "pomegranate", "rhubarb", "jackfruit",
            "serendipity", "ephemeral", "obfuscate"};
    }

    public static String selectNormal(){

        Random random = new Random();

        return normal[random.nextInt(normal.length)];
    }

    public static String selectHard(){

        Random random = new Random();

        return hard[random.nextInt(hard.length)];
    }
}
