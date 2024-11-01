class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1); //Rotate whole array
        reverse(nums, 0, k-1);           //Rotete the first k elements
        reverse(nums, k, nums.length-1); //Rotate remaining elements
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}