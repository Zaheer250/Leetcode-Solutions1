class CustomStack {
    ArrayList<Integer> arr;
    int size;
    public CustomStack(int maxSize) {
        arr=new ArrayList<>();
        size=maxSize;
    }
    
    public void push(int x) {
        if(arr.size() == size){
            return;
        }
        arr.add(x);
    }
    
    public int pop() {
        if(arr.size() < 1){
            return -1;
        }
        return arr.remove(arr.size()-1);
    }
    
    public void increment(int k, int val) {
        int peak=k;
        if(k>arr.size()){
            peak=arr.size();
        }
        for(int i=0;i<peak;i++){
            arr.set(i, arr.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */