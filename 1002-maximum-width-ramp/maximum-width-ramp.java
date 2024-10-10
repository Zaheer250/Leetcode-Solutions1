class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans=0;

        for(int i=0;i<nums.length;i++){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }
        }

        for(int j=nums.length-1;j>=0;j--){
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]){
                ans=Math.max(ans, j-st.peek());
                st.pop();
            }
        }

        return ans;
    }
}