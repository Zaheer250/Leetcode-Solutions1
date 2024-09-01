class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> s=new ArrayDeque<>();
        int[] temp=new int[nums.length];

        for(int i=2*(nums.length);i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%nums.length]){
                s.pop();
            }
            if(s.isEmpty()){
                temp[i%nums.length] = -1;
            }
            else{
                temp[i%nums.length] = s.peek();
            }
            s.push(nums[i%nums.length]);
        }
        return temp;
    }
}