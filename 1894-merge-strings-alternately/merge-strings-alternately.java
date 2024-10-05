class Solution {
     public static String mergeAlternately(String word1, String word2) {
        int wordPointer1 = 0;
        int wordPointer2 = 0;
        StringBuilder merged = new StringBuilder();

        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++){
            merged.append(word1.charAt(wordPointer1));
            merged.append(word2.charAt(wordPointer2));
            wordPointer1++;
            wordPointer2++;
        }

        if (wordPointer1 >= word1.length()){
            merged.append(word2.substring(wordPointer2, word2.length()));
        } else if (wordPointer2 >= word2.length()){
            merged.append(word1.substring(wordPointer1, word1.length()));
        }

        return merged.toString();
    }
}