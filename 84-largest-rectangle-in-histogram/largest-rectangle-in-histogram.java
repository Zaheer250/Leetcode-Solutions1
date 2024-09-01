class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0,curr=0;
        int[] nsl=new int[heights.length];
        int[] nsr=new int[heights.length];
        Stack<Integer> st=new Stack<>();

        //Next Smaller Right

        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=heights.length;
            }
            else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        st = new Stack<>(); //Emptying the stack
        //Next Smaller Left

        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }

        //Calculate Max Area

        for(int i=0;i<heights.length;i++){
            int ht=heights[i];
            int wt=nsr[i]-nsl[i]-1;
            curr = ht*wt;
            max=(int)Math.max(max,curr);
        }

        return max;
    }
}