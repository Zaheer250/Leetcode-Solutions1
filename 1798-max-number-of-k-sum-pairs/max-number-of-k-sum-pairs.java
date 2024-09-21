class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0,high=nums.length-1;
        int cnt=0;
        while(low<high){
            if(nums[low] + nums[high] == k){
                cnt+=1;
                low++;
                high--;
            }
            else if(nums[low] + nums[high] < k){
                low++;
            }
            else{
                high--;
            }
        }

        return cnt;
    }
}