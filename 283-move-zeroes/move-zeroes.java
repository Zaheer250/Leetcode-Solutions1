class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                c+=1;
            }
            else{
                temp=nums[i];
                nums[i]=0;
                nums[i-c]=temp;
            }
        }
    }
}
