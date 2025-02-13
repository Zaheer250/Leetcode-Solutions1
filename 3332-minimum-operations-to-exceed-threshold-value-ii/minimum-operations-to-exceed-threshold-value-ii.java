class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i : nums){
            pq.add((long)i);
        }
        int count=0;
        while(pq.size() >= 2 && pq.peek() < k){
            long x=(long)pq.poll();
            long y=(long)pq.poll();

            long ans=(2L*x) + y;
            pq.add(ans);
            count+=1;
                       
        }

        return count;
    }
}