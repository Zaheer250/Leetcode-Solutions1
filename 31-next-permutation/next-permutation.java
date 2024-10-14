class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                pivot=i;
                break;
            }
        }

        if(pivot == -1){
            Arrays.sort(nums);
            return;
        }

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[pivot]){
                int temp=nums[pivot];
                nums[pivot]=nums[i];
                nums[i]=temp;
                break;
            }
        }

        int i=pivot+1;
        int j=nums.length-1;
        while(i<=j){
            int temp1=nums[i];
            nums[i]=nums[j];
            nums[j]=temp1;
            i++;
            j--;
        }

    }
}

             //Intuition//
/*
1. Find the pivot element from the back of the array
i.e., element which is smaller than its next element.

2. If not found(means there is not next permutation), reverse the array(ascending order)

3. If found, firstly swap the pivot element with its next greatest element from the back

4. Then, finally reverse the remaining array(From the element next to pivot to the end)
*/