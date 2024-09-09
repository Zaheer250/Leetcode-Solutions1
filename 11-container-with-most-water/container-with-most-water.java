class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int h=0, w=0;
        int low=0, high=n-1;
        int max=Integer.MIN_VALUE;
        while(low<high){
            h = (int)Math.min(height[low],height[high]);
            w = high-low;
            int curr = h * w;
            max = (int)Math.max(max,curr);

            if(height[low] < height[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return max;
    }
}