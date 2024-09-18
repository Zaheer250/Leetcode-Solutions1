class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int nums[]){
        for(int i=nums.length/2;i>=0;i--){
            heapify(nums,i,nums.length);
        }

        for(int i=nums.length-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;

            heapify(nums,0,i);
        }   
    }

    public void heapify(int arr[], int i, int n){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx=i;

            if(left < n && arr[maxIdx]<=arr[left]){
                maxIdx=left;
            }
            if(right < n && arr[maxIdx]<=arr[right]){
                maxIdx=right;
            }

            if(maxIdx != i){
                int temp=arr[maxIdx];
                arr[maxIdx]=arr[i];
                arr[i]=temp;

                heapify(arr, maxIdx, n);
            }
        }
}