public class L520 {
    public static void main(String... args) {
        System.out.println(new L520().detectCapitalUse("LeetCode"));
    }

    static public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        if (count == word.length()) {
            return true;
        } else if (count == 0) {
            return true;
        } else if (count == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }
}