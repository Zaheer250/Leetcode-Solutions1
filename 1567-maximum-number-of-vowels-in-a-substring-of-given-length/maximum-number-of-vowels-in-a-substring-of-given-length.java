class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int ans=0;
        int max=Integer.MIN_VALUE;
        int i=0, j=0;

        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                ans+=1;
            }

            if(j-i+1 < k){
                j++;
            }

            else if(j-i+1 == k){
                max=Math.max(ans,max);
                if(set.contains(s.charAt(i))){
                    ans-=1;
                }
                i++;
                j++;
            }
        }

        return max;
    }
}