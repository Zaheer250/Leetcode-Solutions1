import java.util.*;
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Hashtable<Character,Integer> h1=new Hashtable<>();
        Hashtable<Character,Integer> h2=new Hashtable<>();

        for(int i=0;i<jewels.length();i++){
            if(h1.containsKey(jewels.charAt(i))){
                h1.replace(jewels.charAt(i),h1.get(jewels.charAt(i))+1);
            }
            else{
                h1.put(jewels.charAt(i),1);
            }
        }

        for(int i=0;i<stones.length();i++){
            if(h2.containsKey(stones.charAt(i))){
                h2.replace(stones.charAt(i),h2.get(stones.charAt(i))+1);
            }
            else{
                h2.put(stones.charAt(i),1);
            }
        }
        int cnt=0;
        for(char ch : h1.keySet()){
            if(h2.containsKey(ch)){
                cnt+=h2.get(ch);
                h2.replace(ch,h2.get(ch)-1);
            }
            else{
                continue;
            }
        }

        return cnt;
    }
}