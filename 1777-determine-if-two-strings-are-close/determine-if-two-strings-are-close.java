import java.util.*;
class Solution {
    public boolean closeStrings(String word1, String word2) {
         if (word1.length() != word2.length()) {
            return false; 
        }
        Hashtable<Character,Integer> ht=new Hashtable<>();
        Hashtable<Character,Integer> ht1=new Hashtable<>();
        for (int i = 0; i < word1.length(); i++) {
            ht.put(word1.charAt(i), ht.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            ht1.put(word2.charAt(i), ht1.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (!ht.keySet().equals(ht1.keySet())) {
            return false;
        }

        List<Integer> l1=new ArrayList<>(ht.values());
        List<Integer> l2=new ArrayList<>(ht1.values());


        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);

    }
}