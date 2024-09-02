import java.util.*;
class MinStack {
    private Stack<Integer> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        Iterator < Integer > itr = st.iterator();
        int minElement = st.peek();
        while (itr.hasNext()) {
            int x = itr.next();
            if (x < minElement)
                minElement = x;
        }
        return minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */