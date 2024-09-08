class Solution {
    public boolean isSubsequence(String s, String t) {
       int i=0, j=0;
       int cnt=0;
       while((i<s.length()) && (j<t.length())){
        if(s.charAt(i) == t.charAt(j)){
            cnt+=1;
            i+=1;
            j+=1;
        }
        else{
            j+=1;
        }
       }
       return (cnt == s.length()); 
    }
}