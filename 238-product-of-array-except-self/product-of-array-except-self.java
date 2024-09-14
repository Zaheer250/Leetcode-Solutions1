class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        int[] res = new int[nums.length];

        arr1[0] = 1;
        arr2[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
            arr1[i] = nums[i-1] * arr1[i-1];
        }

        for(int j=nums.length-2;j>=0;j--){
            arr2[j] = nums[j+1] * arr2[j+1];
        }

        for(int k=0;k<nums.length;k++){
            res[k] = arr1[k] * arr2[k];
        }

        return res;

    }
}