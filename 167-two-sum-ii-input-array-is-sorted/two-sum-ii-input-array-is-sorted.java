class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low=0;
        int high=numbers.length-1;

        while(low<high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                break;
            }

            else if(sum > target){
                high-=1;
            }
            else{
                low+=1;
            }
        }

        return new int[]{low+1,high+1};
    }
}