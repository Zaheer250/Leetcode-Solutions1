class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        ans[0]=0;
        int temp=0;
        for(int i=1;i<=n;i++){
            String s=Integer.toBinaryString(i);
            for(int j=0;j<s.length();j++){
                temp+=(s.charAt(j)-'0');
            }
            ans[i]=temp;
            temp=0;
        }

        return ans;
    }
}