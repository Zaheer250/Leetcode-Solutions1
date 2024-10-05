class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        if(m>n){   //No permutation of s1 exists in s2
            return false;
        }

        int[] s1_freq=new int[26];  //Frequency of s1
        int[] s2_freq=new int[26];  //Frequency of s2

        for(int i=0;i<s1.length();i++){
            s1_freq[s1.charAt(i)-'a']+=1;     //Store all char freq of s1
        }

        for(int i=0;i<m;i++){
            s2_freq[s2.charAt(i)-'a']+=1; //Store first window freq of s2
        }

        for(int i=0;i<n-m;i++){
            if(Arrays.equals(s1_freq,s2_freq)){
                return true;
            }

            if(i+m<n){  //If so change the window to the next
                s2_freq[s2.charAt(i)-'a']-=1;

                s2_freq[s2.charAt(i+m)-'a']+=1;
            }
        }

        return Arrays.equals(s1_freq,s2_freq);
    }
}