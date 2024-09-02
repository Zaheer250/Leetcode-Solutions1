class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str="";
        int a=0,b=0;
        int n1=word1.length();
        int n2=word2.length();
        while(a<n1 && b<n2){
            str+=word1.charAt(a);
            str+=word2.charAt(b);
            a+=1;
            b+=1;
        }

        if(n1 == n2){
            return str;
        }
        else if(n1 > n2){
            while(a<n1){
                str+=word1.charAt(a);
                a+=1;
            }
        }
        else{
            while(b<n2){
                str+=word2.charAt(b);
                b+=1;
            }
        }

        return str;

    }
}