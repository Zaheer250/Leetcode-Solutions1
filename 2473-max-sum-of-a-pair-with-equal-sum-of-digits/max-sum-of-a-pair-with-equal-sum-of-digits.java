class Solution {
    public int maximumSum(int[] nums) {
        int[] max_sum=new int[82]; //size based on constraint
        int ans=-1;

        for(int val : nums){
            int sum=0;
            int temp=val;
            while(temp!=0){
                sum+=(temp%10);
                temp=temp/10;
            }
            if(max_sum[sum] != 0){
                ans = Math.max(ans,max_sum[sum]+val);
            }
            max_sum[sum]=Math.max(max_sum[sum],val);
        }

        return ans;
    }
}