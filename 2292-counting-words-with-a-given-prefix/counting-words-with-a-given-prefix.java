class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            String str=words[i];
            if(str.startsWith(pref)){
                cnt+=1;
            }
        }

        return cnt;
    }
}