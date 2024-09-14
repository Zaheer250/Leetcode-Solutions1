class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=0,maxcnt=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(max == nums[i]){
                cnt++;
            }
            else{
                maxcnt=Math.max(maxcnt,cnt);
                cnt=0;
            }
        }
        maxcnt=Math.max(maxcnt,cnt);
        if(maxcnt == 0){
            return 1;
        }
        return maxcnt;
    }
}