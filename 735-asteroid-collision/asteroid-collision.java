class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            int a = asteroids[i];
            if(a > 0){
                st.push(a);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek() < -a){
                    st.pop();      //Pop till the -ve ast.> +ve ast.
                }

                if(st.isEmpty() || st.peek() < 0){
                    st.push(a);  //Push if we get -ve ast. as peek
                }

                if(st.peek() == -a){
                    st.pop();  //Don't push and pop the peek if both are same value
                }
            }
        }

        int[] ans = new int[st.size()];

        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }

        return ans;
    }
}