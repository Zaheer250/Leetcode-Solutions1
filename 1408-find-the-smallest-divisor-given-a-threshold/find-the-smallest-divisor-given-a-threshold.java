class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>high){
                high=nums[i];
            }
        }

        while(low<=high){
            int mid = low+(high-low)/2;
            if(calc(nums,threshold,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }

    public boolean calc(int[] nums, int threshold, int mid){
        int sum=0;
        for(int val: nums){
            sum+=Math.ceil((double)val / (double)mid);
        }

        return sum<=threshold;
    }
}