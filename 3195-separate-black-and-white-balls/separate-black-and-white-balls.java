class Solution {
    public long minimumSteps(String s) {
        long swaps=0;
        int blacks=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == '0'){
                swaps+=(long)blacks;
            }
            else{
                blacks++;
            }
        }

        return swaps;
    }
}