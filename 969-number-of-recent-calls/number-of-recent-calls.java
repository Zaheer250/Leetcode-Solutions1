class RecentCounter {
    Queue<Integer> q;;
    public RecentCounter() {
        q=new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        int cnt=0;
        for(Integer temp : q){
            if(temp <= t && (t-3000) <= temp){
                cnt+=1;
            }
        }

        return cnt;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */