package word.wordselect;

public class Word {
    public static String WordHardEasy (String difficulty){
        String[] words = {"apple", "banana", "orange", "watermelon", "pineapple", "grape",
            "strawberry", "blueberry", "blackberry", "cantaloupe", "kiwifruit",
            "peach", "plum", "pear", "cherry", "melon", "fig", "date", "kiwi",
            "avocado", "coconut", "lime", "mango", "papaya", "lychee", "durian",
            "apricot", "tangerine", "cranberry", "nectarine", "guava", "grapefruit",
            "dragonfruit", "persimmon", "pomegranate", "rhubarb",
            "jackfruit", "lemon", "lime", "mango", "grape","Serendipity","Ephemeral","Obfuscate",
            "applicaion","second","cooperation","gossip","clever","cilantro","service","newstart"};

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
        int su = (int)(Math.random()*longIndex);
        int su2 = (int)(Math.random()*shortIndex);

        if ("easy".equals(difficulty)) {
            return longWords[su];
        } else if ("hard".equals(difficulty)) {
            return shortWords[su2];
        } else {
            // 예외 처리: 매개변수가 "easy"나 "hard"가 아닌 경우
            return null;
        }



    }

}
